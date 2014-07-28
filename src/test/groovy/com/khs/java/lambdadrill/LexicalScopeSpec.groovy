package com.khs.java.lambdadrill

import spock.lang.Specification

class LexicalScopeSpec extends Specification {
	
	def scope
	
	def setup() {
		scope = new LexicalScope()
	}
	
	def "test????"() {
		
		expect:
		scope.scope1()
		scope.scope2()
		1
	}

}
