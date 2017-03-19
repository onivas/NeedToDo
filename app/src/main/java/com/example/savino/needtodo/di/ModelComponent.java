package com.example.savino.needtodo.di;

import com.example.savino.needtodo.model.Person;

import dagger.Component;

@Component(modules = {ModelModule.class})
public interface ModelComponent {

//    void inject(MainActivity mainActivity);

    Person providePerson();
}
