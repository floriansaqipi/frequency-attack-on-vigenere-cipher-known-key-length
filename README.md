# Frequency Attack on Vigenere Cipher with Known Key Length

This project focuses on performing a frequency attack on a Vigenere cipher with a known key length. Given a large input text file encrypted using the Vigenere cipher, the goal is to decipher the text by treating each character of the key as a separate cipher. By employing clever techniques, we conduct frequency analysis on each character of the key, decrypting the text character by character and eventually producing the decrypted output in a plain text file.

## Overview

The Vigenere cipher with a known key length can be equated to a monoalphabetic substitution cipher for each character of the key. Leveraging frequency analysis, we identify the most frequent characters in the ciphertext and match them with the most common characters in the English or Albanian language. By pairing these characters, we derive the key used to encrypt the ciphertext. The decrypted text is then stored in an output text file, and in the console, simple statistical graphs and the deciphered key are printed.

## Technical Details

- **Language**: Java
- **File Handling**: Utilizes `FileReader` and `FileWriter` classes for efficient scanning and writing of files word by word.
- **Architecture**: Implements an interface and an abstract class to define most decryption steps, allowing for easy extension and language addition by other users.
- **Design Pattern**: Utilizes Factories for improved application architecture.
- **Algorithm**: Employs an array of HashMaps, each corresponding to a character in the key, to track character counts in the ciphertext. Frequency analysis is performed for each substitution cipher. These counts are then mapped to the frequency of characters in the target language, efficiently deriving the key for each character of the Vigenere key.

## Requirements and How to Run

- **Java Version**: Compatible with any Java JDK. Alternatively, can be run using IntelliJ IDEA software.
- **Execution**: Run the Java application through your preferred method, providing the input text file and specifying the key length.
- **Output**: The decrypted text will be saved in an output text file, and statistical graphs along with the deciphered key will be displayed in the console.

## Contributors

- [Florian Saqipi](https://github.com/floriansaqipi/)
- [Genci Berisha](https://github.com/neg-c)
- [Fjolla Ajeti](https://github.com/fjolla-ajeti)
- [Fortesa Cena](https://github.com/Fortesacena)

## Acknowledgment

We acknowledge the support and contributions of all contributors to this project, enabling the development and enhancement of this frequency attack on Vigenere cipher with known key length.