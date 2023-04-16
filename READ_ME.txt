Ky program është realizuar nga Grupi 20 me anëtartët: Florian Saqipi, Genci Berisha, Fjolla Ajeti dhe Fortesa Cena.

--Aplikacioni është realizuar përmes gjuhës programuese Java dhe ka libraritë e nevojshme të Java-fx për
  zgjerim të mëtejshëm. Aplikacioni për momentin punon me dy gjuhë pra Shqipe dhe Angleze, mirëpo shtimi
  i një gjuhe të re merr fare pak kohë për shkak të planifikimit me kujdes të aplikacionit.

--Aplikacioni i krijuar ka për qëllim sulmin e një file të enkriptuar përmes Vigenere Cipher me gjatësi
  të njohur të çelësit, duke përdorur analizën frekuencorë të karaktereve. Pra, aplikacioni analizon tekstin të
  ndarë si lloj kolonash në bazë të gjatësisë së çelësit, pastaj procesi thjeshtohet pasi për secilën kolonë
  thjesht realizohet analiza frekuencore për një cipher monoalfabetik. Në mënyrë që ta dekriptoj këtë file
  dhe ta shkruaj rezultatin në një output file.

--Input file në verzionin Shqip src/main/java/com/example/decrypter/files/input_shqip.txt
--Input file në verzionin Anglez gjendet në lokacionin src/main/java/com/example/decrypter/files/input.txt

--Rezultati shfaqet ne output file në lokacionin src/main/java/com/example/decrypter/files/output.txt

--Programi mund të ekzekutohet duke bërë run Main file në lokacionin src/main/java/com/example/decrypter/Main.java

--Programi për momentin mund të dekriptoj dy files një në Gjuhën Angleze dhe tjetrën në Gjuhën Shqipe
  të dyja e shkruajnë tekstin e dekriptuar në output file.

--Nëse duam të dekriptojmë textin në Gjuhën Shqipe dekomentojmë line 24 dhe komentojmë line 23 në Main file
--Nëse duam të dekriptojmë textin në Gjuhën Angleze dekomentojmë line 23 dhe komentojmë line 24 në Main file

--Pas ekzekutimit do shkruhet teksti i dekriptuar në output file si dhe shfaqen statistika dhe grafe në konsolë, pra informata.