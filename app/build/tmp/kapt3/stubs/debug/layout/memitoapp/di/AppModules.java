package layout.memitoapp.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0007\u00a8\u0006\r"}, d2 = {"Llayout/memitoapp/di/AppModules;", "", "()V", "provideDataBase", "Lcom/clerodri/memitoapp/data/data_source/TodoDataBase;", "app", "Landroid/app/Application;", "provideTodoRepository", "Lcom/clerodri/memitoapp/domain/usecases/repository/TodoRepository;", "db", "provideTodoUsesCases", "Lcom/clerodri/memitoapp/domain/usecases/TodoUsesCases;", "repository", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModules {
    @org.jetbrains.annotations.NotNull
    public static final layout.memitoapp.di.AppModules INSTANCE = null;
    
    private AppModules() {
        super();
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.clerodri.memitoapp.data.data_source.TodoDataBase provideDataBase(@org.jetbrains.annotations.NotNull
    android.app.Application app) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.clerodri.memitoapp.domain.usecases.repository.TodoRepository provideTodoRepository(@org.jetbrains.annotations.NotNull
    com.clerodri.memitoapp.data.data_source.TodoDataBase db) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.clerodri.memitoapp.domain.usecases.TodoUsesCases provideTodoUsesCases(@org.jetbrains.annotations.NotNull
    com.clerodri.memitoapp.domain.usecases.repository.TodoRepository repository) {
        return null;
    }
}