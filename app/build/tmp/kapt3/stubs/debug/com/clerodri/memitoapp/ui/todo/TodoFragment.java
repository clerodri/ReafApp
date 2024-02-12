package com.clerodri.memitoapp.ui.todo;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010&\u001a\u00020\'H\u0002J\b\u0010(\u001a\u00020\'H\u0002J\b\u0010)\u001a\u00020\'H\u0002J$\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020\'2\u0006\u00103\u001a\u000204H\u0002J\u001a\u00105\u001a\u00020\'2\u0006\u00106\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00107\u001a\u00020\'H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/clerodri/memitoapp/ui/todo/TodoFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/clerodri/memitoapp/databinding/FragmentTodoBinding;", "binding", "getBinding", "()Lcom/clerodri/memitoapp/databinding/FragmentTodoBinding;", "btnAddTodo", "Landroid/widget/Button;", "getBtnAddTodo", "()Landroid/widget/Button;", "setBtnAddTodo", "(Landroid/widget/Button;)V", "dialog", "Landroid/app/Dialog;", "etName", "Landroid/widget/EditText;", "etValue", "llManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "test", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/clerodri/memitoapp/ui/todo/RegistrationTodoState;", "todoAdapter", "Lcom/clerodri/memitoapp/ui/todo/TodoAdapter;", "todoListAdapter", "", "Lcom/clerodri/memitoapp/domain/modelo/TodoInfo;", "todoViewModel", "Lcom/clerodri/memitoapp/ui/todo/TodoViewModel;", "getTodoViewModel", "()Lcom/clerodri/memitoapp/ui/todo/TodoViewModel;", "todoViewModel$delegate", "Lkotlin/Lazy;", "tvErrorName", "Landroid/widget/TextView;", "tvErrorValue", "initAdapter", "", "initDialog", "initRV", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemDeleted", "position", "", "onViewCreated", "view", "writingTodoName", "app_debug"})
public final class TodoFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy todoViewModel$delegate = null;
    @org.jetbrains.annotations.Nullable
    private com.clerodri.memitoapp.databinding.FragmentTodoBinding _binding;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.clerodri.memitoapp.domain.modelo.TodoInfo> todoListAdapter;
    private com.clerodri.memitoapp.ui.todo.TodoAdapter todoAdapter;
    private androidx.recyclerview.widget.LinearLayoutManager llManager;
    public android.widget.Button btnAddTodo;
    private android.app.Dialog dialog;
    private android.widget.EditText etName;
    private android.widget.EditText etValue;
    private android.widget.TextView tvErrorName;
    private android.widget.TextView tvErrorValue;
    private kotlinx.coroutines.flow.StateFlow<com.clerodri.memitoapp.ui.todo.RegistrationTodoState> test;
    
    public TodoFragment() {
        super();
    }
    
    private final com.clerodri.memitoapp.ui.todo.TodoViewModel getTodoViewModel() {
        return null;
    }
    
    private final com.clerodri.memitoapp.databinding.FragmentTodoBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.Button getBtnAddTodo() {
        return null;
    }
    
    public final void setBtnAddTodo(@org.jetbrains.annotations.NotNull
    android.widget.Button p0) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void writingTodoName() {
    }
    
    private final void initAdapter() {
    }
    
    private final void initRV() {
    }
    
    private final void onItemDeleted(int position) {
    }
    
    private final void initDialog() {
    }
}