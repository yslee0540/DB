db.getCollection("memo").find({})

db.memo.find({name: "Tom", office: "Seoul"}, {phone: 1}).count()

db.memo.find({$or : [{name: "Tom"}, {office: "Seoul"}]},{phone: 1})
//{$or : [{조건키:값}, {조건키:값}]}

db.memo.find({office: "Busan"}, {_id:0, office:1, phone:1})

db.memo.find({office: {$not: /Busan/}}, {_id:0, office:1, phone:1}).limit(3)

db.memo.deleteOne({office: "Wordware"})

db.memo.find({office: "Wordware"})

db.memo.updateMany({office: "Seoul"}, {$set: {phone: "999"}})

db.memo.find({office: "Seoul"}, {phone: 1})

db.memo.deleteMany({})

db.memo.find({}).count()

//확인문제
db.memo.find({office: "Wordware"}, {age:1, phone:1})

db.memo.find({age: 1}, {office: 1, name: 1}).count()

db.memo.insertOne({"age": 200, "name": "hong", "office": "busan", "phone": "011"})

db.memo.find({})

db.memo.updateOne({age: 2}, {$set: {office: "seoul"}})

db.memo.find({$or : [{age: 2}, {office: "busan"}]})

db.memo.deleteOne({age: 3})

db.memo.find({age: 3})

db.memo.updateOne({name: "Didi"}, {$set: {office: "ulsan"}})

db.memo.find({name: "Didi"})

db.memo.deleteMany({})

db.memo.drop()

show collections


