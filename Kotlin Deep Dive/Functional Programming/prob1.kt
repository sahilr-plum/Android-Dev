data class Student(
    val name: String,
    val age: Int,
    val grades: List<Int>,
    val isActive: Boolean
)

val students = listOf(
    Student("Alice", 20, listOf(85, 90, 88), true),
    Student("Bob", 22, listOf(70, 75, 72), true),
    Student("Charlie", 21, listOf(95, 92, 98), false),
    Student("Diana", 20, listOf(88, 85, 90), true),
    Student("Eve", 23, listOf(60, 65, 62), false)
)

// 1. Get names of all active students with average grade >= 80
fun getTopActiveStudents(students: List<Student>): List<String> {
    return students
        .asSequence()
        .filter { student -> 
            student.grades.average() >= 80 && student.isActive
        }
        .map { student ->
            student.name
        }
        .toList()
}

//2. Calculate average age of students grouped by their performance
// Performance: "Excellent" (avg >= 90), "Good" (80-89), "Average" (70-79), "Poor" (< 70)
fun averageAgeByPerformance(students: List<Student>): Map<String, Double> {
    return students
        .groupBy { student ->
            when (student.grades.average()) {
                in 90.0..100.0 -> "Excellent"
                in 80.0..89.0 -> "Good"
                in 70.0..79.0 -> "Average"
                else -> "Poor"
            }
        }
        .mapValues { entry ->
            entry.value.map { it.age }.average()
        }
}

// 3. Get total count of all grades above 85 across all students
fun countHighGrades(students: List<Student>): Int {
    return students
        .asSequence()
        .flatMap {
            it.grades.toList()
        }
        .count { grade -> 
            grade > 85
        }
}

//4. Create a function that returns a function
//The returned function should filter students by minimum average grade
fun createGradeFilter(minAverage: Double): (Student) -> Boolean {
    return { student: Student ->
        student.grades.average() >= minAverage
    }
}

fun main() {
    val allStudent = getTopActiveStudents(students)

    allStudent.forEach { println(it) }

    val totalHighGrades = countHighGrades(students)
    println("Total grades above 85: $totalHighGrades")

    val averageAges = averageAgeByPerformance(students)
    averageAges.forEach { (performance, avgAge) ->
        println("$performance: $avgAge") }

    val gradeFilter = createGradeFilter(80.0)
    val filteredStudents = students.filter(gradeFilter)
    println("Students with average grade >= 80:")
    filteredStudents.forEach { println(it.name) }
}