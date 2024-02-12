package com.clerodri.memitoapp.data.todo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bH\u0016J\u0019\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/clerodri/memitoapp/data/todo/TodoRepositoryImpl;", "Lcom/clerodri/memitoapp/domain/usecases/repository/TodoRepository;", "dao", "Lcom/clerodri/memitoapp/data/data_source/TodoDao;", "(Lcom/clerodri/memitoapp/data/data_source/TodoDao;)V", "deleteTodo", "", "todo", "Lcom/clerodri/memitoapp/domain/modelo/TodoInfo;", "(Lcom/clerodri/memitoapp/domain/modelo/TodoInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTodos", "Lkotlinx/coroutines/flow/Flow;", "", "insertTodo", "app_debug"})
public final class TodoRepositoryImpl implements com.clerodri.memitoapp.domain.usecases.repository.TodoRepository {
    @org.jetbrains.annotations.NotNull
    private final com.clerodri.memitoapp.data.data_source.TodoDao dao = null;
    
    public TodoRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.clerodri.memitoapp.data.data_source.TodoDao dao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.clerodri.memitoapp.domain.modelo.TodoInfo>> getTodos() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertTodo(@org.jetbrains.annotations.NotNull
    com.clerodri.memitoapp.domain.modelo.TodoInfo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object deleteTodo(@org.jetbrains.annotations.NotNull
    com.clerodri.memitoapp.domain.modelo.TodoInfo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}