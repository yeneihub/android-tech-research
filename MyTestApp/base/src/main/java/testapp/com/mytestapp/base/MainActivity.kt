package testapp.com.mytestapp.base

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject
import android.arch.lifecycle.Observer

class MainActivity : AppCompatActivity(), LifecycleOwner {

    @Inject
    lateinit var mainActivityViewModelFactory: MainActivityViewModelFactory

    private val viewModel by lazy {
        ViewModelProviders.of(this, mainActivityViewModelFactory).get(MainActivityViewModel::class.java)
    }

    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "My Test App"
        (application as MyApplication).myComponent.inject(this)
        viewModel.data.observe(this, Observer {
            content.text = it?.joinToString { data -> "${data?.id}. ${data.toString()}\n" }
        })
        btn.setOnClickListener {
            viewModel.addData(
                data = Data(0, property1 = Date().toString(), property2 = count.toString()),
                onComplete = {
                viewModel.getDataList()
            })
            count += 1
        }
    }
}
