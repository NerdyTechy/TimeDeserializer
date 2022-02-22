# TimeDeserializer
> A simple Java library for deserializing string formatted time values into seconds.
---
## Implementation
After downloading the latest release and importing the binary, declare an instance at the top of your class.
```java
private final TimeDeserializer td = new TimeDeserializer();
```
You can then use `td#deserialize()` to convert the string into a long with the amount of seconds.
```java
Long l = td.deserialize("2w"); // returns 1209600
```

## Multiple Time Values
If you would like to use multiple time values, for example 2 weeks and 2 days, separate the values with either a comma (,) or a colon (:).
```java
Long l = td.deserialize("2w:2d"); // returns 1382400
Long l2 = td.deserialize("2m,2s"); // returns 122
```

## Time Definitions
- `s` - Seconds
- `m` - Minutes
- `h` - Hours
- `d` - Days
- `w` - Weeks
