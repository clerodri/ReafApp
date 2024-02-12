// Generated by view binder compiler. Do not edit!
package com.clerodri.memitoapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.clerodri.memitoapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogTodoBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnAdd;

  @NonNull
  public final EditText etTodoName;

  @NonNull
  public final TextView etTodoNameError;

  @NonNull
  public final EditText etValue;

  @NonNull
  public final TextView etValueError;

  private DialogTodoBinding(@NonNull LinearLayout rootView, @NonNull Button btnAdd,
      @NonNull EditText etTodoName, @NonNull TextView etTodoNameError, @NonNull EditText etValue,
      @NonNull TextView etValueError) {
    this.rootView = rootView;
    this.btnAdd = btnAdd;
    this.etTodoName = etTodoName;
    this.etTodoNameError = etTodoNameError;
    this.etValue = etValue;
    this.etValueError = etValueError;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogTodoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogTodoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_todo, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogTodoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAdd;
      Button btnAdd = ViewBindings.findChildViewById(rootView, id);
      if (btnAdd == null) {
        break missingId;
      }

      id = R.id.etTodoName;
      EditText etTodoName = ViewBindings.findChildViewById(rootView, id);
      if (etTodoName == null) {
        break missingId;
      }

      id = R.id.etTodoNameError;
      TextView etTodoNameError = ViewBindings.findChildViewById(rootView, id);
      if (etTodoNameError == null) {
        break missingId;
      }

      id = R.id.etValue;
      EditText etValue = ViewBindings.findChildViewById(rootView, id);
      if (etValue == null) {
        break missingId;
      }

      id = R.id.etValueError;
      TextView etValueError = ViewBindings.findChildViewById(rootView, id);
      if (etValueError == null) {
        break missingId;
      }

      return new DialogTodoBinding((LinearLayout) rootView, btnAdd, etTodoName, etTodoNameError,
          etValue, etValueError);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}