//package com.gylee.kotlincoroutines.show
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.*
//import kotlinx.android.synthetic.main.activity_main.*
//import java.math.BigDecimal
//
//class NameViewModel : ViewModel() {
//
//    // Create a LiveData with a String
//    val currentName: MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }
//
//    // Rest of the ViewModel...
//}
//
//class NameActivity : AppCompatActivity() {
//
//    private lateinit var model: NameViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // Other code to setup the activity...
//
//        // Get the ViewModel.
////        model = ViewModelProvider.of(this).get(NameViewModel::class.java)
////        model = ViewModelProvider
//
//        // Create the observer which updates the UI.
//        val nameObserver = Observer<String> { newName ->
//            // Update the UI, in this case, a TextView.
////            nameTextView.text = newName
//        }
//
//        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//        model.currentName.observe(this, nameObserver)
//
//
//        val userName: LiveData<String> = Transformations.map(model.currentName) {
//                name -> "$name  fdfd"
//        }
//
//        val user = Transformations.switchMap(userId) { id -> getUser(id) }
//
//
//    }
//
//    fun test() {
//        tvContent.setOnClickListener {
//            model.currentName.value = "335"
//        }
//    }
//}
//
//class StockLiveData(symbol: String) : LiveData<BigDecimal>() {
//    private val stockManager = StockManager(symbol)
//
//    private val listener = { price: BigDecimal ->
//        value = price
//    }
//
//    override fun onActive() {
//        stockManager.requestPriceUpdates(listener)
//    }
//
//    override fun onInactive() {
//        stockManager.removeUpdates(listener)
//    }
//}
//
//val userLiveData: LiveData<User> = UserLiveData()
//val userName: LiveData<String> = Transformations.map(userLiveData) {
//        user -> "${user.name} ${user.lastName}"
//}
//
//private fun getUser(id: String): LiveData<String>  =
