# Blood Donation App


## Blood Donation event
It has place, duration, blood quantity, and list of donors. The number of the donors (what on the list) depends the event duration and the number of doctors.

## Doctors
The doctors have name. They can take blood if there are minimum 2 doctors on the event. 2 doctors can take blood only from 2 donors in an hour. Pair of doctors have to work together. It means 2 doctors can take blood from 1 donor, and 3 doctors also can take only from 1 donors, but 4 doctors can take blood from 2 donor, and so on...

## Donors
The donors have name, birthday, blood quantity, ID, email address. The donors can register to an event if they are over 14 years and they can do blood donation if they add blood more than 7 days. The donors can donate only on that case if his/her remaining blood in minimum 1 unit.

## Hints
* Do NOT use static fields & methods
* Put some Exception into the app