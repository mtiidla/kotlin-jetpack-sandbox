package ee.mtiidla.jetpacksandbox.codelab


object Injection {

    lateinit var appComponent: AppComponent
        private set

    fun init(app: CodelabApp) {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(app))
                .build()
    }

}