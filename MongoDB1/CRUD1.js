use shop5

db.memo.find({})

db.createUser({
    user: "winner",
    pwd: "1234",
    roles: ["readWrite", "dbAdmin"]
})

show users

//10
use shop10

db.memo.find({})

db.memo.count({})

db.memo.insertOne({
    "name": "apple",
    "age" : 100
})

db.memo.find({"name" : "apple"})

db.memo.find({"age" : 100})

db.createCollection("member")

db.member.stats()

db.member.insertOne({
    "name": "hong2",
    "age": 100,
    "tel": "010"
})

db.member.find({})

db.createCollection("bbs")

db.bbs.insertOne({"title": "win"})

db.bbs.find({})

db.dropDatabase()

show databases

use shop5

show databases

db.createCollection("member")

db.member.insertOne({
    "id": "hong",
    "pw": "1234",
    "name": "honggildong",
    "tel": "011"
})

db.member.find({})

db.member.insertMany([
    {"id": "kim", "pw": "1234", "name": "kimdong", "tel": "012"},
    {"id": "park", "pw": "1234", "name": "parkdong", "tel": "013"}
])

db.member.drop()

db.dropDatabase()

show databases

