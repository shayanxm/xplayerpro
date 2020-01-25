package fakhteh.fanavaran.mydagger.di.component.moduel

import android.content.Context
import com.example.xplayer.di.qualifier.ApplicationContextQuailfier
import com.example.xplayer.di.scopes.CustomApplicationScope
import dagger.Module
import dagger.Provides
@Module
class AppModuel(@ApplicationContextQuailfier private var contextd: Context) {

//lateinit var conti:Context
//    init {
//        this.context = context.applicationContext
//    }
//
//    @ApplicationContextQuailfier
//    @Provides
//    @CustomApplicationScope
//    fun provideContext() = context

    //    override fun onCreate() {
//        super.onCreate()
//        conti=applicationContext
//
//    }
    val contexti: Context? = null


    //@ApplicationContextQuailfier
    @Provides

    @CustomApplicationScope
    fun provideContext(): Context = contextd
}