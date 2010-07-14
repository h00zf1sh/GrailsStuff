package com.morgz

class Category {
    String name

    String description

    static belongsTo = [user: User]

    static hasMany = [todos: Todo]

    static constraints = {
        name(blank: false)
    }

    String toString() {
        name
    }
}
