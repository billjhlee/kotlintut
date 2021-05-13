package com.example.tut.transform

interface Transformer<A, B> {
    fun transform(source: A):B
}