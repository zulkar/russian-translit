# Russian-translit

Simple library to transliterate russian cyrillic to latin using different schemas

## How to use
Usage is very simple

```java
import io.github.zulkar.translit.Translit;

String latin = Translit.translit("Съешь ещё этих мягких французских булок, да выпей чаю");
```

By default [ICAO DOC 9309](https://www.icao.int/publications/Documents/9303_p3_cons_en.pdf) schema used.

At the moment, the library supports this schemas:

* [ICAO DOC 9309](https://www.icao.int/publications/Documents/9303_p3_cons_en.pdf)
* [ISO 9:1995](https://en.wikipedia.org/wiki/ISO_9)
* [GOST 7.79-2000](https://en.wikipedia.org/wiki/GOST_7.79-2000) - A and B schemas

To use appropriate schema  use
```java
String latin = Translit.translit("Съешь ещё этих мягких французских булок, да выпей чаю", Translit.iso9());
```


### Schema comparison
Only Russian language supported now. Other cyrillic languages are not implemented

How this sentence to be transliterated:

`Съешь ещё этих мягких французских булок, да выпей чаю`

###### ICAO DOC 9309
`Sieesh eshche etikh miagkikh frantsuzskikh bulok, da vypei chaiu`

###### ISO 9:1995 and GOST 7.79-2000 System A 
`Sʺešʹ eŝë ètih mâgkih francuzskih bulok, da vypej čaû`

###### ISO 9:1995 and GOST 7.79-2000 System B
`S``esh` eshhyo e`tix myagkix franczuzskix bulok, da vy`pej chayu` 


### Upper case characters
Upper case characters are transliterated with only first letter in upper case, e.g.
* Юрий -> Iurii (ISO 9)
* ДЮСШ -> DIuSSh


### Prerequisites
Java 1.6 or later.


### Installing

Add this to your pom.xml file
```xml
<dependency>
    <groupId>io.github.zulkar</groupId>
    <artifactId>russian-translit</artifactId>
    <version>0.1</version>
</dependency>
```

## Licensing

Russian-translit library is licensed under the Apache License, Version 2.0. See [LICENSE](https://github.com/moby/moby/blob/master/LICENSE) for the full license text.
