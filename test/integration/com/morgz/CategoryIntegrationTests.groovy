package com.morgz

import grails.test.*

class CategoryIntegrationTests extends GrailsUnitTestCase {
    // Test Data
    final static NAMES = [
        "Cat1",
        "Cat2",
        "Cat3"
    ]

    final static DESCS = [
        "Cat1 Desc",
        "Cat2 Desc",
        "Cat3 Desc"
    ]

    protected void setUp() {
        super.setUp()

        Category.list()*.delete()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testPersist() {
        new Category(
            name: NAMES[0],
            description: DESCS[0]
        ).save()

        new Category(
            name: NAMES[1],
            description: DESCS[1]
        ).save()

         new Category(
            name: NAMES[2],
            description: DESCS[2]
        ).save()

        assert 3 == Category.count()

        def foundCategory = Category.findByName(NAMES[0])

        assert foundCategory

        assert NAMES[0] == foundCategory.name
    }

    void testToString() {
        def category = new Category(name: NAMES[0])

        assertToString(category, NAMES[0])
    }
}
