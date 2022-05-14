


hours = int(input("In how many hours would you like to wake up at? "))

day = hours // 24

remaining_hours = hours % 24

minuntes = remaining_hours // 60

remaining_minuntes = minuntes % 60

seconds = remaining_minuntes // 60

remaining_seconds = seconds % 60

time = day, "days", remaining_hours, "hours", remaining_minuntes, "minuntes", remaining_seconds, "seconds"

print("Great! Then you will wake up in", time)


clock = remaining_hours + 14

if clock > 24:
    
    clock_time = (clock - 24), "AM"    


elif clock > 12:
    clock_time = (clock - 12), "PM"

print("The time will be", clock_time)



