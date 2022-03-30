# Unit Testing Fundamentals

Sample code based on Mosh Hamedani's course named "Unit Testing for C# Developers" written in Kotlin

## Key points

- Unit tests should be small, around 3-5 lines of code whenever possible.
- Test classes should follow the naming convention of [ClassUnderTest]Tests.
- Method names should follow the naming convention of [MethodName]_[State]_[ExpectedBehavior], which is also known as Given_When_Then in B.D.D.
- When dealing with external dependencies, we should try to decouple the code using dependency injection, extracting an interface of that dependency and creating a mocking it.
- When faced with repeated parts in our Unit Tests, specially in the Arrange part, we should use a Setup method and promote those local variables to properties inside our Tests class.
- There are two types of Unit Tests, State-based and Behavior-based tests.