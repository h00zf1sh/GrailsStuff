package com.morgz

class Todo {

    String name
    String note
    Date createdDate
    Date dueDate
    Date completedDate
    String priority
    String status

    static constraints = {
        name(blank :false)
        createdDate()
        priority()
        status()
        dueDate()
        note(maxSize: 1000, nullable: true)
        completedDate(nullable: true)
        dueDate(nullable: true)
    }

    String toString() {
        name
    }
}
