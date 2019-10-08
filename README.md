# Tesztautomatizálás oktatás

```javascript
var jsonData = pm.response.json();
var id = jsonData.id;

console.log(id);
```

```javascript
let id = pm.globals.get("globalId");

let jsonData = pm.response.json();

let name = "unknown";
for (i = 0; i < jsonData.content.length; i++) {
    if (jsonData.content[i].id == id) {
        name = jsonData.content[i].name;
    }
}

console.log(name);

pm.test("Check name", function () {
    pm.expect(name).to.eql("Orfű-Viczián-Postman");
});
```
