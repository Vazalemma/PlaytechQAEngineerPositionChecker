This assignment seemed suspiciously easy.
I just had to figure out how to add Selenium to IntelliJ IDEA, which didn't take me long.
After that, I just did some research to see how the general flow of Selenium works.

I opened Playtech.ee, used Chrome to do the tasks (Firefox was an elternative).
Had to also download ChromeBrowser.exe to C://, so now I have that.




The most difficult part was trying to figure out how to do coordinates. It didn't work.
Here's some code snippets I was trying to use:

import org.openqa.selenium.interactions.Actions;

int x = element.getLocation().getX();
int y = element.getLocation().getY();
Actions actions = new Actions(driver);
actions.moveByOffset(x + 1, y + 1).click().build().perform();

Not only did the getX() and getY() not work for some reason, crashing the code,
but also perform() didn't work, even without coordinates, aka all of these:

actions.moveToElement(element).click().perform();
actions.moveToElement(element).click().build().perform();
actions.moveToElement(element).moveByOffset(50, 70).click().perform();
actions.moveToElement(element).moveByOffset(50, 70).click().build().perform();

I tried various things, but I can't think of anything specific that's wrong here,
so I assume it's some deeper technical thing I'm unaware of.
Regardless, I don't think coordinate clicking is that important,
it's inconsistent with window/screen sizes anyway
which is why I have maximize() still in the code.




After that, it was still smooth sailing.
I used PrintWriter at first, but switched to FileWriter later to append instead.
I added a timestamp to keep track of when the tests were done, could be useful info.
And then I made it into a junit 4.0 test.

Simple and straightforward.

