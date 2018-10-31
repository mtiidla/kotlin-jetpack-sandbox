package ee.mtiidla.jetpacksandbox.codelab.ui.detail

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@AssistedModule
@Module(includes = arrayOf(AssistedInject_ViewModelFactoryModule::class))
abstract class ViewModelFactoryModule