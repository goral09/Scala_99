package problems.scala.listProblems

import Predef._
import annotation.tailrec

object ListProblems extends App {
	def lastElement[A](l: List[A]): Option[A] = if(l.isEmpty) None else Some(l.reverse.head)

	def lastButOne[A](l: List[A]): Option[A] = l match {
		case Nil => None
		case x :: xs :: Nil => Some(x)
		case x :: xs => lastButOne(xs)
	}

	def kthElement[A](n: Int,l: List[A]): A = n match {
		case 0 => l.head
		case x => kthElement(n-1, l.tail)
	}

	def lengthOfList[A](l: List[A]): Int = l.foldLeft(0)((a,_) => a + 1)

	def reverse[A](l: List[A]): List[A] = l.foldRight(List[A]())((c,a) => a :+ c)

	def isPalindrome[A](l: List[A]): Boolean = l == l.reverse

	def flatten(l: List[Any]): List[Any] = l flatMap {
		case ms: List[_] => flatten(ms)
		case e => List(e)
	}

	def removeDuplicates[A](l: List[A]): List[A] = l match {
		case Nil=> Nil
		case x :: xs => x :: removeDuplicates(xs.dropWhile(_ == x))
	}

	def pack[A](l: List[A]): List[List[A]] = l match {
		case Nil => Nil
		case x :: xs => x +: xs.takeWhile(_ == x) :: pack(xs.dropWhile(_ == x))
	}

	def encode[A](l: List[A]): List[(Int, A)] = pack(l).map( v => (v.length, v.head))

	def encodeModified[A](l: List[A]): List[Any] = pack(l).map( v => if(v.length > 1) (v.length, v.head) else v.head)

	def decode[A](l: List[(Int,A)]): List[A] = l.flatMap( v => List.fill(v._1)(v._2) )

	def decodeTR[A](l: List[(Int, A)]): List[A] = {
		@tailrec
		def helper(n: Int, list: List[(Int,A)], acc: List[A]): List[A] = list match {
			case Nil => acc
			case x :: xs => {
				if(x._1 > n) helper(n + 1, list, acc :+ x._2)
				else helper(0, xs, acc)
			}
		}
		helper(0, l, Nil)
	}

	def duplicate[A](l: List[A]): List[A] = l.flatMap(e => List(e,e))

	def duplicateN[A](n: Int,l: List[A]): List[A] = l.flatMap(e => List.fill(n)(e))
}