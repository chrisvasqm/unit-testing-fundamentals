package fundamentals

import javax.naming.OperationNotSupportedException

class Stack<T> {
    private val items = mutableListOf<T>()

    val count: Int
        get() = items.size

    fun push(item: T?) {
        if (item == null)
            throw IllegalArgumentException("Item can not be null.")

        items.add(item)
    }

    fun pop(): T {
        if (items.size == 0)
            throw OperationNotSupportedException("The Stack is empty.")

        return items.removeLast()
    }

    fun peek(): T {
        if (items.size == 0)
            throw OperationNotSupportedException("The Stack is empty.")

        return items.last()
    }

    override fun toString(): String {
        return "Stack(count=$count, items=$items)"
    }
}