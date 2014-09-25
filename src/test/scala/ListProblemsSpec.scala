package problems.scala.listProblems
package utils

import org.scalatest._
import ListProblems._
import scala.util.Random

class ListProblemsSpec extends UnitSpec {
	"1. " should "return last element" in {
		val list: List[Int] = List(1,2,3,4,5)
		val last: Int = 5
		val returned = lastElement(list)

		returned should be (Some(last))
	}

	it should "return None for empty list" in {
		val list: List[Int] = List[Int]()
		val returned = lastElement(list)

		returned should be (None)
	}

	"2. " should "return last but one element" in {
		val list: List[Int] = List(1,2,3,4,5)
		val last: Int = 4
		val returned = lastButOne(list)

		returned should be (Some(last))
	}

	it should "return None for empty list" in {
		val list: List[Int] = List[Int]()
		val returned = lastButOne(list)

		returned should be (None)
	}

	"3. " should "return K-th element of list" in {
		val list: List[Int] = List(1,2,3,4,5,6,7,8)
		val k = Random.nextInt(list.length)
		val kth = list(k)
		val returned = kthElement(k, list)

		returned should be (kth)
	}

	"4. " should "return length of the list" in {
		val list: List[Int] = List(1,2,3,4,5,6,7,8)
		val length = list.length
		val returned = lengthOfList(list)

		returned should be (length)
	}

	"5. " should "reverse a list" in {
		val list: List[Int] = List(1,2,3,4,5,6,7,8)
		val reversed = list.reverse
		val returned = reverse(list)

		assert(returned === reversed)
	}

	"6. " should "find whether a list is palindrome" in {
		val list: List[Int] = List(1,2,3,4,5,6,7,8)
		val returned = isPalindrome(list)
		assert(returned == (list == list.reverse))
	}

	"7. " should "flatten a nestesd list structure" in {
		val list = List(List(1, 1), 2, List(3, List(5, 8)))
		val flattened = List(1,1,2,3,5,8)
		val returned = flatten(list)

		returned should be(flattened)
	}
	
	def listWithDuplicates = new {
		val list = List('a,'a,'a,'a,'a,'b,'b,'b,'c,'c,'d,'d,'d,'d,'d,'d,'e,'e,'e)
		val list2 = list :+ 'f
		val noDups = List('a,'b,'c,'d,'e)
		val encoded = List( (5,'a), (3,'b), (2,'c), (6, 'd), (3,'e) )
	}

	"8. " should "remove duplicates in the list" in {
		val returned = removeDuplicates(listWithDuplicates.list)

		returned should be (listWithDuplicates.noDups)
	}

	"9. " should "pack consecutive elements of list" in {
		val returned = pack(listWithDuplicates.list)

		returned should be ( List(List('a,'a,'a,'a,'a), List('b,'b,'b), List('c,'c), List('d,'d,'d,'d,'d,'d),List('e,'e,'e)) )
	}

	"10. " should "return run-length encoding of list" in {
		val returned = encode(listWithDuplicates.list)

		returned should be ( List( (5,'a), (3,'b), (2,'c), (6, 'd), (3,'e) ) )
	}

	"11. " should "return modified encoding of list for sublists with only one element" in {
		val returned = encodeModified(listWithDuplicates.list2)

		returned should be ( List( (5,'a), (3,'b), (2,'c), (6, 'd), (3,'e), 'f ) )
	}

	"12. " should "decode a run-length encode list" in {
		val returned = decode(listWithDuplicates.encoded)
		val returnedTR = decodeTR(listWithDuplicates.encoded)

		returned should be (listWithDuplicates.list)
		returnedTR should be (listWithDuplicates.list)
	}

	"14. " should "duplicate elements of a list" in {
		val returned = duplicate(listWithDuplicates.noDups)

		returned should be (List('a,'a,'b,'b,'c,'c,'d,'d,'e,'e))
	}

	"15. " should "duplicate elements of a list N times" in {
		val returned = duplicateN(3, listWithDuplicates.noDups)

		returned should be (List('a,'a,'a, 'b,'b,'b,'c,'c,'c,'d,'d,'d,'e,'e,'e))
	}

	"16. " should "drop every nth element of a list" in {
		val returned = dropN(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

		returned should be (List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
	}
}