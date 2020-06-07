# **Manual for SDP Encryptor**

## App Details

Author: aabdelwahed3  
Date: 6/7/2020  
Course: SDP6300Summer2020


## Table of Contents

1. Introduction  
1.1 Purpoe and Scope
1.2 Process Overview
2. Starting and Using Distance Converter  
2.1 Starting the app  
2.2 Using the app
3. Quick Reference

## 1 Introduction

### 1.1 Scope and Purpose

This Encryptor is a an andriod app developed to encrypt text based messages using Ceasor's Cipher. It take in message, a key, and a incrementor. 

### 1.2 Process Overview

The Encryptor is packaged as an Andriod Studio project and can only run on Android based Os's. To import, you must use Android Studio

## 2 Starting and Using Distance Converter

### 2.1 Starting app

After launching the Encryptor app in Andriod Studo, use the built in Andriod emulator or a connected Android device to run the app.
For best performance refrain from using anything besdies Pixel 3 API 28 (Pie).

### 2.2 Using app

After you build successfull and the app runs, you will see the app interface is presented in the emulator or your device screen.

You can follow the bellow steps to use the app:

1. Enter a message in the corresponding message field
This message takes in any alphabetic character, numeric, or symbol. Keep in mind that the message must be atleast one character long and there must be aleast one alphabetic character within that message.

2. Enter a numeric value in the corresponding Key Number Field
Here you must enter a digit inbetween 1 and 26.

3. Enter a numeric value in the corresponding Increent Number Field
Here you must enter another digit inbetween 1 and 26.

Keep in mind all the fields must have a value matching the above criteria for this Encryptor to operate

4. Encrypt  
After providing said values. The Encryptor will run a cipher by shifting the first alphabetic character by the key number, and then for every alphabetic character after that, you shift by the key number added to the increment number multiplied by the total number of increments so far. Once this step is performed. the cipher converts all lowercase characters to upper and vice versa.


## 3 Quick Reference

Abbreviation:  
&nbsp; &nbsp; &nbsp;message - length > 0 && 1 alphateic  
&nbsp; &nbsp; &nbsp;key - 0 < number < 27
&nbsp; &nbsp; &nbsp;increment - 0 < number < 27