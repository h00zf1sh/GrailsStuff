package com.morgz

import grails.test.*

class TodoIntegrationTests extends GrailsUnitTestCase {

    final static NAMES = [
        "Stop Bills",
        "Pay Papers",
        "Invade Czech Republic"]
                            
    protected void setUp() {
        super.setUp()

        Todo.list()*.delete()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testPersist() {
        new Todo(name: NAMES[0],
                 createdDate: new Date(),
                 priority: "",
                 status: "").save()

        new Todo(name: NAMES[1],
                 createdDate: new Date(),
                 priority: "",
                 status: "").save()

         new Todo(name: NAMES[2],
                 createdDate: new Date(),
                 priority: "",
                 status: "").save()

        assert 3 == Todo.count()

        def foundTodo = Todo.findByName(NAMES[0])

        assert foundTodo

        assert NAMES[0] == foundTodo.name
    }

    void testToString() {
        def todo = new Todo(name: NAMES[0])
        
        assertToString(todo, NAMES[0])
    }
}
