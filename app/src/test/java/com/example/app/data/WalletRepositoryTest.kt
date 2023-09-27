package com.example.app.data

import com.example.app.core.request.ErrorMessage
import com.example.app.core.request.RequestState
import com.example.app.core.request.SuccessMessage
import com.example.app.data.adapters.WalletRepositoryAdapter
import com.example.app.data.models.AssetDao
import com.example.app.domain.entities.Asset
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
class WalletRepositoryTest {

    @Mock
    lateinit var localRepository: LocalWalletRepository

    @Mock
    lateinit var webSearchRepository: WebSearchRepository

    @Mock
    lateinit var walletRepositoryAdapter: WalletRepositoryAdapter

    private lateinit var walletRepository: WalletRepository

    @Before
    fun setUp() {
        walletRepository =
            WalletRepository(localRepository, webSearchRepository, walletRepositoryAdapter)
    }

    @Test
    fun `when localRepository returns non-null, getWallet should return success with wallet assets`() {
        // Arrange
        val mockAssetDao = listOf(AssetDao())
        val mockAsset = listOf(Asset())
        `when`(walletRepositoryAdapter.createAsset(mockAssetDao.first())).thenReturn(mockAsset.first())
        `when`(localRepository.getWallet()).thenReturn(mockAssetDao)

        // Act
        val result = walletRepository.getWallet()


        assertEquals(RequestState.Success(mockAsset).data, (result as RequestState.Success).data)
    }

    @Test
    fun `when localRepository returns null, getWallet should return success with empty list`() {
        // Arrange
        `when`(localRepository.getWallet()).thenReturn(null)

        // Act
        val result = walletRepository.getWallet()

        // Assert
        assertEquals(
            RequestState.Success(emptyList<AssetDao>()).data,
            (result as RequestState.Success).data
        )
    }

    @Test
    fun `getAsset returns success when asset is found`() {
        val mockCode = "mockCode"
        val mockAsset = AssetDao(code = mockCode)
        `when`(localRepository.getAsset(mockCode)).thenReturn(mockAsset)

        val result = walletRepository.getAsset(mockCode)

        assertTrue(result is RequestState.Success)
        assertEquals(mockAsset, (result as RequestState.Success).data)
    }

    @Test
    fun `getAsset returns error when asset is not found`() {
        val mockCode = "mockCode"
        `when`(localRepository.getAsset(mockCode)).thenReturn(null)

        val result = walletRepository.getAsset(mockCode)

        assertTrue(result is RequestState.Error)
        assertTrue((result as RequestState.Error).error is ErrorMessage.CodeNotFound)
    }

    @Test
    fun `deleteAsset returns success when asset is found and deleted`() {
        val mockCode = "mockCode"
        val mockAsset = AssetDao(code = mockCode)
        `when`(localRepository.getAsset(mockCode)).thenReturn(mockAsset)

        val result = walletRepository.deleteAsset(mockCode)

        assertTrue(result is RequestState.Success)
        assertTrue((result as RequestState.Success).success is SuccessMessage.AssetAdd)
    }

    @Test
    fun `deleteAsset returns error when asset is not found`() {
        val mockCode = "mockCode"
        `when`(localRepository.getAsset(mockCode)).thenReturn(null)

        val result = walletRepository.deleteAsset(mockCode)

        assertTrue(result is RequestState.Error)
        assertTrue((result as RequestState.Error).error is ErrorMessage.CodeNotFound)
    }


    @Test
    fun `addAsset returns success when asset is added`() = runTest {
        val mockCode = "mockCode"
        val mockPrice = "10.0"
        val mockUnits = 1f
        val mockGoal = 10f
        `when`(localRepository.assetExists(mockCode)).thenReturn(false)
        `when`(webSearchRepository.fetchPriceFromWeb(mockCode)).thenReturn(mockPrice)

        val result = walletRepository.addAsset(mockCode, mockUnits, mockGoal)

        assertTrue(result is RequestState.Success)
        assertTrue((result as RequestState.Success).success is SuccessMessage.AssetAdd)
    }


    @Test
    fun `addAsset returns error when asset code already exists`() = runTest {
        val mockCode = "mockCode"
        val mockUnits = 1f
        val mockGoal = 10f
        `when`(localRepository.assetExists(mockCode)).thenReturn(true)

        val result = walletRepository.addAsset(mockCode, mockUnits, mockGoal)

        assertTrue(result is RequestState.Error)
        assertTrue((result as RequestState.Error).error is ErrorMessage.CodeAlreadyAdd)
    }

    @Test
    fun `addAsset returns error when asset price not found on web`() = runTest {
        val mockCode = "mockCode"
        val mockUnits = 1f
        val mockGoal = 10f
        `when`(localRepository.assetExists(mockCode)).thenReturn(false)
        `when`(webSearchRepository.fetchPriceFromWeb(mockCode)).thenReturn(null)

        val result = walletRepository.addAsset(mockCode, mockUnits, mockGoal)

        assertTrue(result is RequestState.Error)
        assertTrue((result as RequestState.Error).error is ErrorMessage.CodeNotFound)
    }


}
