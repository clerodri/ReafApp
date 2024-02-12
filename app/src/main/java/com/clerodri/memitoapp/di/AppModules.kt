package layout.memitoapp.di

import android.app.Application
import androidx.room.Room
import com.clerodri.memitoapp.data.data_source.TodoDataBase
import com.clerodri.memitoapp.data.todo.TodoRepositoryImpl
import com.clerodri.memitoapp.domain.usecases.repository.TodoRepository
import com.clerodri.memitoapp.domain.usecases.AddTodo
import com.clerodri.memitoapp.domain.usecases.DeleteTodo
import com.clerodri.memitoapp.domain.usecases.GetTodos
import com.clerodri.memitoapp.domain.usecases.TodoUsesCases
import com.clerodri.memitoapp.domain.usecases.ValidateTodoName
import com.clerodri.memitoapp.domain.usecases.ValidateValueTodo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModules {

    @Singleton
    @Provides
    fun provideDataBase(app: Application): TodoDataBase {
        return Room.databaseBuilder(
            app,
            TodoDataBase::class.java,
            TodoDataBase.DATABASE_NAME
        ).build()
    }


    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDataBase) : TodoRepository {
        return TodoRepositoryImpl(db.todoDao)
    }

    @Provides
    @Singleton
    fun provideTodoUsesCases(repository: TodoRepository): TodoUsesCases{
        return TodoUsesCases(
            addTodo = AddTodo(repository),
            deleteTodo = DeleteTodo(repository),
            getTodos = GetTodos(repository),
            validateTodoName = ValidateTodoName(),
            validateValueTodo = ValidateValueTodo()
        )
    }
}