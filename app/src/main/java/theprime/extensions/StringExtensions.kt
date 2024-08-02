package theprime.extensions

val String.reverseDomainName get() = split('.').reversed().joinToString(".")