
Those provided drawable(2).zip files usually contain pizza images (PNG/JPG/WebP) or vector XMLs.

If the ZIP contains images like pizza_1.png, pizza_2.png, etc.

Unzip it

Copy the files into:

app/src/main/res/drawable/

Make sure filenames are lowercase + underscore only, e.g.:

✅ pizza_1.png

❌ Pizza 1.png (spaces/uppercase break resource naming)

Then in code you can reference:

R.drawable.pizza_1

If the ZIP contains density folders (common)

Sometimes you’ll see:

drawable-hdpi/

drawable-xhdpi/

drawable-xxhdpi/

In that case, copy each folder into:
app/src/main/res/ (preserve folder names). Android will pick the right resolution automatically.

If you have no images yet

Create a temporary drawable:

app/src/main/res/drawable/pizza_1.xml (and reuse it), or just add one placeholder PNG and point all pizzas to it for now.