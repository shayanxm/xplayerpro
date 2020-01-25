package fakhteh.fanavaran.mydagger.di.component.commp

import com.example.xplayer.di.scopes.CustomApplicationScope
import com.example.xplayer.ui.viewpagerfragements.baseholder.BaseHolderViewModel
import dagger.Component

import fakhteh.fanavaran.mydagger.di.component.moduel.AppModuel
import fakhteh.fanavaran.mydagger.di.component.moduel.SongLab

@CustomApplicationScope
@Component(modules = [AppModuel::class,SongLab::class])
interface SongLabComponent {

    fun injectViewModel(baseHolderViewModel: BaseHolderViewModel)

}