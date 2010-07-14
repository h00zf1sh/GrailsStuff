package com.morgz

import grails.test.*

class UserIntegrationTests extends GrailsUnitTestCase {
     // Test Data
    final static USERNAMES = [
        "bbaggins1",
        "bbaggins2",
        "bbaggins3"
    ]

    final static FIRSTNAMES = [
        "Bilbo1",
        "Bilbo2",
        "Bilbo3"
    ]

    final static LASTNAMES = [
        "Baggins1",
        "Baggins2",
        "Baggins3"
    ]

    protected void setUp() {
        super.setUp()

        User.list()*.delete()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testPersist() {
        new User(
            userName: USERNAMES[0],
            firstName: FIRSTNAMES[0],
            lastName: LASTNAMES[0]
        ).save()

        new User(
            userName: USERNAMES[1],
            firstName: FIRSTNAMES[1],
            lastName: LASTNAMES[1]
        ).save()

        new User(
            userName: USERNAMES[2],
            firstName: FIRSTNAMES[2],
            lastName: LASTNAMES[2]
        ).save()

        assert 3 == User.count()

        def foundUser = User.findByUserName(USERNAMES[0])

        assert foundUser

        assert USERNAMES[0] == foundUser.userName

    }

    void testToString() {
        def user = new User(
            userName: USERNAMES[0],
            firstName: FIRSTNAMES[0],
            lastName: LASTNAMES[0]
        )

        assertToString(user, LASTNAMES[0] + ", " + FIRSTNAMES[0])
    }
}
