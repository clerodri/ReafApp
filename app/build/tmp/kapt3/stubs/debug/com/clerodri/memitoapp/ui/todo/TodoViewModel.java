package com.clerodri.memitoapp.ui.todo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u001aH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f\u00a8\u0006\""}, d2 = {"Lcom/clerodri/memitoapp/ui/todo/TodoViewModel;", "Landroidx/lifecycle/ViewModel;", "todoUsesCases", "Lcom/clerodri/memitoapp/domain/usecases/TodoUsesCases;", "(Lcom/clerodri/memitoapp/domain/usecases/TodoUsesCases;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/clerodri/memitoapp/ui/todo/TodoState;", "_validationUIState", "Lcom/clerodri/memitoapp/ui/todo/RegistrationTodoState;", "fectchJob", "Lkotlinx/coroutines/Job;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "validationEventChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/clerodri/memitoapp/ui/todo/TodoViewModel$ValidationEvent;", "validationEvents", "Lkotlinx/coroutines/flow/Flow;", "getValidationEvents", "()Lkotlinx/coroutines/flow/Flow;", "validationUIState", "getValidationUIState", "getListTodo", "", "onEvent", "event", "Lcom/clerodri/memitoapp/ui/todo/TodoEvent;", "onEventValidation", "Lcom/clerodri/memitoapp/ui/todo/RegistrationTodoEvent;", "submitData", "ValidationEvent", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class TodoViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.clerodri.memitoapp.domain.usecases.TodoUsesCases todoUsesCases = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<com.clerodri.memitoapp.ui.todo.TodoState> _uiState;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.clerodri.memitoapp.ui.todo.TodoState> uiState = null;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job fectchJob;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<com.clerodri.memitoapp.ui.todo.RegistrationTodoState> _validationUIState;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.clerodri.memitoapp.ui.todo.RegistrationTodoState> validationUIState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.channels.Channel<com.clerodri.memitoapp.ui.todo.TodoViewModel.ValidationEvent> validationEventChannel = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.clerodri.memitoapp.ui.todo.TodoViewModel.ValidationEvent> validationEvents = null;
    
    @javax.inject.Inject
    public TodoViewModel(@org.jetbrains.annotations.NotNull
    com.clerodri.memitoapp.domain.usecases.TodoUsesCases todoUsesCases) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.clerodri.memitoapp.ui.todo.TodoState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.clerodri.memitoapp.ui.todo.RegistrationTodoState> getValidationUIState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.clerodri.memitoapp.ui.todo.TodoViewModel.ValidationEvent> getValidationEvents() {
        return null;
    }
    
    public final void onEventValidation(@org.jetbrains.annotations.NotNull
    com.clerodri.memitoapp.ui.todo.RegistrationTodoEvent event) {
    }
    
    private final void submitData() {
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull
    com.clerodri.memitoapp.ui.todo.TodoEvent event) {
    }
    
    private final void getListTodo() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/clerodri/memitoapp/ui/todo/TodoViewModel$ValidationEvent;", "", "()V", "Success", "Lcom/clerodri/memitoapp/ui/todo/TodoViewModel$ValidationEvent$Success;", "app_debug"})
    public static abstract class ValidationEvent {
        
        private ValidationEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/clerodri/memitoapp/ui/todo/TodoViewModel$ValidationEvent$Success;", "Lcom/clerodri/memitoapp/ui/todo/TodoViewModel$ValidationEvent;", "()V", "app_debug"})
        public static final class Success extends com.clerodri.memitoapp.ui.todo.TodoViewModel.ValidationEvent {
            @org.jetbrains.annotations.NotNull
            public static final com.clerodri.memitoapp.ui.todo.TodoViewModel.ValidationEvent.Success INSTANCE = null;
            
            private Success() {
            }
        }
    }
}