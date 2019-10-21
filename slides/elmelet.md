---

class: inverse, center, middle

# Webes alkalmazás

---

## Webes alkalmazások

* Böngésző a kliens
	* Microsoft Internet Explorer, Microsoft Edge
	* Mozilla Firefox
	* Google Chrome
* Mivel böngésző mindenütt telepített, megszűnnek a telepítési/frissítési problémák
* Vékony kliensnek is nevezik, utalva arra, hogy a logika főleg szerver oldalon van
	* Elegendő csak ott frissíteni
* Háttérben a HTTP, HTML, CSS, JavaScript technológiák

---

## URL

* Uniform Resource Locator
* Interneten található erőforrások (szöveges tartalmak, képek, hangfájlok, videók) egyedi azonosítására
* Felépítése
	* Protokoll
	* Tartománynév
	* Port
	* Elérési út

---

## HTTP(S) protokoll

* 1999-ben kiadott RFC 2616 definiálja a HTTP/1.1-et (W3C szervezet)
* 2015-ben leváltott a HTTP/2.0-ás verzió, amit az RFC 7540 definiál
* Kliens-szerver kommunikáció
* Kliens tipikusan böngésző
* Kérés-válasz alapú protokoll
* Szöveges
* Fejléc, törzs
* Állapotmentes
* (S): secure - SSL alapú titkosítás
* Eszközök: Böngésző Fejlesztői eszköztár

---

## HTTP kérés

```
Accept: text/html,application/xhtml+xm…plication/xml;q=0.9,*/*;q=0.8
Accept-Encoding: gzip, deflate
Accept-Language: hu-HU,hu;q=0.8,en-US;q=0.5,en;q=0.3
Cache-Control: max-age=0
Connection: keep-alive
Cookie: _ga=GA1.2.1967894445.149906973…yis3b41advsb3cwc3b3rk; _gat=1
Host: training360.com
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/57.0

GET http://training360.com/ HTTP/1.1
```

---

## HTTP válasz

```
HTTP/1.1 200 OK
Cache-Control: no-cache
Pragma: no-cache
Content-Type: text/html; charset=utf-8
Content-Encoding: gzip
Server: Kestrel
Set-Cookie: Training360.Session=CfDJ8...s5; path=/; secure; samesite=lax; httponly
Date: Fri, 09 Aug 2019 11:45:51 GMT

<!DOCTYPE html>
<html lang="hu">
<head>
  <!-- ... -->
</head>
<body>
  <!-- ... -->
</body>
</html>
```

---

## Hivatkozott erőforrások

* CSS
* JavaScript
* Képek (tipikusan gif, jpg, svg formátumban)
	* Formátumok közötti különbségek

---

## Státuszkódok

* `200 OK`
* `302 Found`, lsd. később
* `304 Not Modified`, lsd. később
* `400 Bad Request`
* `401 Unauthorized`
* `403 Forbidden`
* `404 Not Found`
* `500 Internal Server Error`

---

## HTTP paraméterek

* Kérdőjellel (`?`) elválasztva
* Egymástól `&` karakterrel elválasztva
* URL encoding

http://training360.com/search.aspx?filter=javax&date=2017.12.01.&chkIT=true&chkOffice=true

http://training360.com/search.aspx?filter=alma%20k%C3%B6rte&date=0&chkIT=true&chkOffice=true

---

## Cache

* `Cache-Control`
	* `Cache-Control` fejléc (mp-ben), az adott tartalmat meddig lehet tárolnia lokálisan a böngészőnek
* `If-Modified-Since`
	* Kliens küldi, kéri a szervert, hogy csak akkor adjon vissza tartalmat, ha módosult azóta
	* `304 Not Modified`

---

## Mime-type

* `Content-Type` header
* Néhány: `text/plain`, `text/html`, `text/javascript`, `text/CSS`, `image/gif`, `image/jpeg`, `application/vnd.ms-excel` (`vnd` - vendor - nem szabványos)

http://www.training360.com/download.aspx?src=tanfolyam_jelentkezes_Training360.doc

```
Content-Type: application/msword
```

---

## Űrlapok

* `POST` metódus

```
POST /contact.aspx HTTP/1.1
Host: http://training360.com
User-Agent: Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/57.0

UserName=demo@example.com&Password=password
```

---

## Cookie

* Szerver hozza létre
* Böngésző tárolja, és minden kéréskor visszaküldi a szervernek
* Csak ugyanannak a szervernek küldheti vissza
* Használata:
	* Pl. nyelv, pénznem (miben írja ki a webáruház az árakat)
	* Session követés (lsd. később)

---

## Állapotmentesség, session

* Két kérés között nincs kapcsolat
* Session (munkamenet): "felhasználónkénti" szerver oldali tárterület egyedi azonosítóval
* Azonosítót leküldi a szerver cookie-ban, melyet a kliens minden kéréssel visszaküld
* Timeout

---

## Átirányítás

* `GET` paraméterek, hossz limit
* `POST` kezelése, felmerülő problémák:
	* Refresh
	* Back gomb használata
	* Könyvjelző
* Redirect after post tervezési minta

---

## HTML formátum

* HyperText Markup Language
* W3C szabvány
* Szöveges formátum
* Szöveges tartalom reprezentálására
* Struktúra és tartalom (hisztorikusan megjelenés is)
* Hiperhivatkozások
* Fej, törzs
* Fa hierarchia
* Tagek

---

## HTML karakterkódolás

* HTML5-ben az alapértelmezett karakterkódolás az `UTF-8`

---

## Egyszerű HTML dokumentum

```html
<!DOCTYPE html>
<html>
    <head>
    	<title>Example</title>
    </head>
    <body>
    	<h1>Example Page</h1>
    	<p>This is an example page.</p>
    </body>
</html>
```

---

## DOM ábrázolás

![DOM](images/dom.jpg)

---

## CSS

* Cascading Style Sheets
* W3C szabvány
* Színek, méretek, elhelyezkedések, betűtípusok
* Elválik a tartalom és a forma
* Könnyebben változtatható a megjelenés
* Szelektorokkal kiválaszható elemeknek adható meg formátum
* Megadható a HTML-be ágyazva, fejlécben és külön állományban is

---

## CSS példa

```html
<h1>A CSS használata</h1>
```

```css
h1 {
    text-align: center;
    color: red;
    font-size: large;
    font-family: "Times New Roman", serif;
    font-style: italic;
}
```

---

## Beágyazott CSS

```html
<h1 style="color: red;">A CSS használata</h1>
```

---

## CSS a fejlécben

```html
<html>
	<head>
		<style>
			h1 {
				color: red;
			}
		</style>
	</head>
	<body>
		<h1>A CSS használata</h1>
	</body>
</html>
```

---

## Hivatkozás külső CSS állományra

```html
<html>
	<head>
		<link rel="stylesheet" href="styles.css" />
	</head>
	<body>
		<h1>A CSS használata</h1>
	</body>
</html>
```

---


---

class: inverse, center, middle

# Webes alkalmazás RIA felülettel

---

## Rich Internet Application (RIA)

* Böngésző a kliens
* Operációs rendszert kihasználó alkalmazásokkal majdnem megegyező funkcionalitást képes nyújtani
* Böngésző technológiák fejlődése tette lehetővé
* Első implementációk: Google várható kifejezések, Google Maps, GMail
* HTML, CSS, JavaScript megoldások
* Adobe Flash, Microsoft Silverlight eltűnőben, JavaFX még nem terjedt el
	* Külön telepítés szükséges, nem a böngészőben beágyazva fut, csak onnan indítható
* Biztonsági vonzatok (homokozó)

---

## Alkalmazás architektúrája

* Gyakori, hogy az üzleti logika, és a felhasználó felület külön
technológiával kerül megvalósításra
* Alkalmazás két részre bontása:
	*	Backend: perzisztencia, üzleti logika
	* Frontend: felhasználói felület

---

## JavaScript

* Programozási nyelv
* Böngészők tudják értelmezni és futtatni
* Manapság böngészőn kívül is kezd terjedni, általános célú nyelvvé válhat
* Független a Java programozási nyelvtől

---

## HTML oldalba ágyazott JavaScript kód

```html
<input type="button" onclick="alert('Hello World!');" value="Click me!" />
```

---

## HTML oldal fejlécébe ágyazott JavaScript kód

```html
<head>
	<script type="text/javascript">
		onload = function() {
			document.getElementById('mybutton').addEventListener('click', 
				function(e) {
						alert('Hello World!');
					});
		}
	</script>
</head>
```

---

## JavaScript külön állományban - html

```html
<!DOCTYPE html>
<html>
<head>
	<script src="myscript.js" type="text/javascript"></script>
</head>
<body>
	<input id="mybutton" type="button" value="Click me!" />
</body
</html>
```

---

## JavaScript külön állományban - js

A `myscript.js` állomány tartalma:

```javascript
onload = function() {
	document
		.getElementById('mybutton')
		.addEventListener('click',
			function(e) {
				alert('Hello World!');
			});
}
```


---

## JSON

* JavaScript Object Notation
* XML leváltására, JavaScript elterjedésével, adatok átvitelére
* Tipikusan böngészős frontend és backend közötti kommunikációra
* Ember és számítógép számára értelmezhető szöveges, kiterjeszthető formátum
	* Érvényes JavaScript kifejezés
* Kulcs-érték párokat (object) és tömböket (array) tartalmaz
* Adattípusok: szám, karakterlánc, logikai
* Speciális üres érték: null
* Fa hierarchia

---

## Példa JSON dokumentum

```javascript
{
  "questions": [
        {
            "text": "Válassza ki az alábbiak közül a helyes állítást!",
            "answers": [
                {
                    "point": 0,
                    "text": "Micimackó szereti a dinnyét."
                },
                {
                    "point": 1,
                    "text": "Micimackó szereti a mézet."
                }
            ],
        }
    ]
}
```

---

## JSON értelmezése JavaScriptből

```javascript
data['questions'][0]['text']

data['questions'][0]['answers'][0]['text']
```

---

## AJAX

* Asynchronous JavaScript and XML
* Technológia a HTML dokumentum (DOM fa) módosítására, lap váltása nélkül,
  szerver oldali adatok alapján
* Megnövelt felhasználói élmény
* Kisebb adatforgalom, csökkenő szerver terhelés
* XML helyett már JSON
* Aszinkron: callback akkor hívódik meg, ha megérkezett a válasz a szervertől

---

## SPA

* Single-page application
* Kihívások
  * Kezdeti betöltődés
	* Keresőoptimalizáció
	* History
	* Analitika

---

## Szerver indította kapcsolatfelvétel (server push)

* HTTP szabvány nem biztosít erre megoldást
* Polling
* HTTP-re épülő "trükkös" megoldások (pl. Comet)
* WebSockets
* HTTP/2 Server Push

---

## Webszolgáltatások

* W3C definíció: hálózaton keresztüli gép-gép együttműködést támogató szoftverrendszer
* Platform független
* Szereplők
	* Szolgáltatást nyújtó
	* Szolgáltatást használni kívánó

---

## RESTful webszolgáltatás

* Roy Fielding: Architectural Styles and the Design of Network-based Software Architectures, 2000
* Representational state transfer
* Egyedileg címezhető erőforrások (resource)
* Uniform, constrained interface for manipulate resources (crud)
* Létező technológiák: URI, HTTP, XML, JSON
* Web Application Description Language (WADL) – nem elterjedt
* AJAX világ segítette az elterjedését

---

## További HTTP metódusok

* `PUT` - feltölti a megadott erőforrást, `POST` működéséhez hasonlatos
* `DELETE` - törli a megadott erőforrást

---

## HTTP-ből újrafelhasznált tulajdonságok

* Kliens-szerver, kérés-válasz
* URI
* HTTP metódusok
* Hibakezelés, státuszkódok
* Header
* Content negotiation, mime-type
* Cache

---

## RESTful webszolgáltatásokat hívó frontend tipikus működése

* Letöltésre kerül a statikus HTML oldal, CSS és JavaScript állományok
* A HTML dokumentumot a CSS alapján lerendereli a böngésző, előáll a DOM
* A böngészőben lévő JavaScript motor (engine) futtatja a JavaScript kódot
* AJAX-szal megtörténik a (GET) hívás a szerver RESTful webszolgáltatása felé
* A szerver visszaadja a választ JSON formátumban
* Meghívásra kerül a callback függvény
* A callback függvény értelmezi a JSON formátumú adatot, és módosítja a DOM fát,
ezáltal a HTML oldalon megjelennek az adatok

---

## RESTful módosítás

* Az AJAX hívás paraméterként egy JSON dokumentumot küld fel
* A szerver oldali RESTful webszolgáltatás értelmezi a JSON adatokat, és
hatására adatot szúr be, módosít vagy töröl az adatbázisban
* Amennyiben sikeres a művelet, erről a klienst értesíti
* A callback függvény tájékoztatja a felhasználót a művelet sikerességéről

---

## Postman

* A Postman egy eszköz és szolgáltatáscsomag API fejlesztéshez
* https://www.getpostman.com/
* Multiplatform: Windows, macOS, Linux
* Támogatás a fejlesztés teljes életciklusában
* Magas szintű csoportmunka (nem csak szoftver, hanem szolgáltatás)
