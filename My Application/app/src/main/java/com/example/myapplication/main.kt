package com.example.myapplication.MainKt

//fun main() {
//    var s1 = "aBcDe"
//    println(s1.toUpperCase()) // 모두 대문자로 변환하는 키워드 toUpperCase()
//    println(s1.toLowerCase()) // 모두 소문자로 변환하는 키워드 toLowerCase()
//    val s2 = s1.toMutableList() // s1에 있는 것을 List 형식으로 하나씩 분활한 작업. Array 도 가능.
//    println(s2) // 변환된 것이 어떻게출력 되는지 확인 한 작업. 그냥 List 형식이다.
//    for (i in s2.indices) { // 인덱스를 넘겨주는 역할, indices 이 없으면 밑에 [] 인덱스 사용이 불가능 했다.
//        println("이번에 들어갈 인덱스 숫자" + i) // 이해가 어려워서 예시로 표현 되게 작성했다.
//        if (s2[i].isUpperCase()) { // 순서대로 갖고오지만 일단 0번째 꺼가 대문자이냐 boolean 값으로 표현 한다. 키워드 isUpperCase()
//            println("변경될 인덱스숫자 $i 소문자로 변경") // 이해를 돕기 위해서 프린트해서 보여준 것
//            s2[i] = s2[i].toLowerCase() // 나는 그 대문자라서 true 가 된 것을 소문자로 변경할 것이다. 키워드 toLowerCase()
//        } else if (s2[i].isLowerCase()) { // 소문자 이냐 확인 boolean 값으로 표현된다.
//            println("변경될 인덱스숫자 $i 대문자로 변경")
//            s2[i] = s2[i].toUpperCase() // 그 소문자를 대문자로 변경한다.
//        }
//    }
//    println(s2) // 그냥 list 형식으로 나열이 된다. 변환은 되었다 이걸 어떻게 그냥 s1 처럼 합칠까 고민을 하니깐.
//    println(s2.joinToString("")) // joinToString 로 이용하여 "" 를 빼면 Char 가 아닌 String 형태로 된다.
//
//}


//fun main () {
//
//    fun solution(my_string: String) = my_string.map {
//        when {
//            it.isUpperCase() -> it.toLowerCase()
//            else -> it.toUpperCase()
//        }
//    }.joinToString("")
//    println(solution("aBcDeFGH"))
//}




//fun main (){
//
//    val str = "AbCdEfGh"
//    println(str)
//    val list = str.toCharArray()
//    println(list)
//    val s = StringBuilder()
//    println(s)
//    for (i in list.indices){
//        println("지금 비교하는 문자의 인덱스 번호 $i")
//        if (list[i].isUpperCase()){
//            println("변경될 대문자  ${list[i]}")
//            s.append(list[1].toLowerCase())
//        } else if (list[i].isLowerCase()){
//            println("변경될 소문자 ${list[i]}")
//            s.append(list[i].toUpperCase())
//        }
//    }
//    println(s.toString())
//}


//fun main(args: Array<String>) {
//    val s1 = "reAdLinE"
//    for (s in s1) {
//        if (s in 'a'..'z') {
//            print(s - 32)
//        } else {
//            print(s + 32)
//        }
//    }
//}   //내가 원하는 그냥 하는 방식. 근데 해석이 너무 많이 필요하다. 아스키 코드


//fun main(){
//    fun solution(my_string: String): String {
//        val strList = mutableListOf<Char>() // 한 글자씩 대소문자 체크하고 리스트에 추가할 예정이라 String이 아닌 Char로 함
//
//        for(i in my_string) { // my_string 한 글자씩 보겠다는 뜻
//            if (i.isUpperCase()) { // 대문자를 소문자로 바꿔서 strList에 추가
////strList.add(i.toLowerCase()) // String 이라면 이 형식으로
//                strList.add(i.lowercaseChar()) // 한 글자씩이라면 lowercaseChar로 하는게 더좋다고 뜸
//            } else { // 소문자를 대문자로 바꿔서 strList에 추가
////strList.add(i.toUpperCase())
//                strList.add(i.uppercaseChar()) // 한 글자씩이라면 uppercaseChar로 하는게 더좋다고 뜸
//            } // 만약 strList가 Char가 아닌 String만 요소로 받는다면 strList.add(i.toLowerCase().toString()) 이렇게 써야 됨
//        }
//        return strList.joinToString("") // 리스트 strList를 합쳐서 문자열로 변환
//    }
//    solution("sKenseSFW")
//    println(solution("sKenseSFW"))
//}
