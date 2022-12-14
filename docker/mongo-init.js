db.createUser(
    {
        user: "usrseries",
        pwd: "pwdseries",
        roles: [
            {
                role: "readWrite",
                db: "seriesdevmongo"
            }
        ]
    }
);