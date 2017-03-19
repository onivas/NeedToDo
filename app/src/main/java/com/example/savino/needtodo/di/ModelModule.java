package com.example.savino.needtodo.di;

import com.example.savino.needtodo.model.Person;

import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {

    // This is just a simple example where we inject Person into MainActivity
    // and give a "default person" by setting the constructor params here
    @Provides
    public Person provideDefaultPerson() {
        return new Person("DefaultName", "DefaultSurname", 33, false);
    }
}
