file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/users/UsersModel.scala
### java.lang.StringIndexOutOfBoundsException: begin 132, end 151, length 150

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.3\scala3-library_3-3.3.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 145
uri: file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/users/UsersModel.scala
text:
```scala
package models.user

case class Users(
    username:String,
    password:String,
    id:Int = 0
)

object Users:
    given Writes[USerse@@]


```



#### Error stacktrace:

```
java.base/java.lang.String.checkBoundsBeginEnd(String.java:4608)
	java.base/java.lang.String.substring(String.java:2711)
	scala.meta.internal.pc.PcSymbolSearch$.isGeneratedGiven(PcSymbolSearch.scala:281)
	scala.meta.internal.pc.PcSymbolSearch.soughtSymbols(PcSymbolSearch.scala:127)
	scala.meta.internal.pc.PcSymbolSearch.soughtSymbols$(PcSymbolSearch.scala:24)
	scala.meta.internal.pc.WithSymbolSearchCollector.soughtSymbols(PcCollector.scala:359)
	scala.meta.internal.pc.PcSymbolSearch.soughtSymbols(PcSymbolSearch.scala:51)
	scala.meta.internal.pc.PcSymbolSearch.soughtSymbols$(PcSymbolSearch.scala:24)
	scala.meta.internal.pc.WithSymbolSearchCollector.soughtSymbols$lzyINIT1(PcCollector.scala:359)
	scala.meta.internal.pc.WithSymbolSearchCollector.soughtSymbols(PcCollector.scala:359)
	scala.meta.internal.pc.WithSymbolSearchCollector.result(PcCollector.scala:366)
	scala.meta.internal.pc.PcDocumentHighlightProvider.highlights(PcDocumentHighlightProvider.scala:32)
	scala.meta.internal.pc.ScalaPresentationCompiler.documentHighlight$$anonfun$1(ScalaPresentationCompiler.scala:187)
```
#### Short summary: 

java.lang.StringIndexOutOfBoundsException: begin 132, end 151, length 150