                                                实验一：安卓计算器
一、需求分析

一个计算器程序，最基本的需求使需要完成十进制正整数的加法、减法、乘法、除法运算，要对输入的数据进行检验，如若输入数据不恰当导致出错，则需要做适当的报错处理，在基础的加减乘除运算当中，需要进行报错提示的为：当使用除法进行运算时，如若除数为零，则给出报错提示。
   
   在上述设计的基础上，计算器功能仍可以扩展，计算器的需求仍有：需完成对数字的正负数情况的考虑，即提供按钮可以供用户进行数字的切换正负数；提高数据的精度，即考虑使加法、减法、乘法、除法运算支持对带小数点的浮点数的运算功能。
   
   当计算器可以支持带小数点的浮点数的加减乘除运算、切换正负数、非法数据的报错提示后，最基础的需求已经完成。在前置的基础功能需求已经完成的条件下，可以添加科学计算器的功能进入此计算器，包括但不限于开平方根运算、三角函数运算和阶乘运算等。对于开平方根运算，需要检验输入数据是否非法，构成非法数据则需要提出报错提示。

实现加、减、乘、除、开平方的运算

提供切换正负的功能

支持带小数点的浮点数运算

当除数为0时，报错提示；当根号下的数为负数时，进行报错提示

二、软件设计（解释过程较为详细，请结合程序代码进行理解，如见到[1]类似形式请忽视，其为文档中参考文献引用部分，相关文献请自行查找）

根据需求分析，可知对于加减乘除运算、求值运算、清零、小数点和数字0-9来说，需要为它们每一个都单独的在前端设置按钮（Button）控件；计算器最后要将计算出来的结果和报错提示直观的显示给用户，因此在此处设置了EditText控件，用来显示运算结果和报错提示，它是TextView的子类，允许用户在控件里输入和编辑内容，并可以在程序中对这些内容进行处理[1]；Button控件和EditText控件全部位于不同排列方式的LinearLayout——线性布局之中，线性布局会将它所包含的控件在线性方向上按垂直或水平方向依次排列。

本软件前端使用了七个线性布局。第一个线性布局包含的布局和控件较多，其本身为垂直方向，其中包括EditText控件、一个包含四个垂直方向线性布局的水平方向的线性布局、一个水平方向的线性布局。EditText控件位于最上方，醒目的提供运算结果和错误提示。包含四个垂直方向的水平方向的线性布局，位于第一个垂直方向的线性布局的中间位置，其中包含了数字1-9、加、减、乘、除、开平方根和清零的Button控件，第一个垂直方向的线性布局，由上到下为清零（AC）、数字7、数字4、数字1的Button控件，第二个垂直方向的线性布局，由上到下为乘法（*）、数字8、数字5、数字2的Button控件，第三个垂直方向的线性布局，由上到下为除法（/）、数字9、数字6、数字3的Button控件，第四个垂直方向的线性布局，由上到下为加法（+）、减法（-）和开平方根（√）的Button控件。最后的一个水平方向的线性布局位于第一个垂直方向的线性布局的底部，由左到右为小数点（.）、数字0、切换正负（+/-）和计算（=）的Button控件。

后台以Activity本身作为事件监听器，首先定义数字0-9、运算符（加、减、乘、除、等于、开平方根）、小数点、清零、切换正负的Button控件和显示结果的EditText控件，同时定义用于记录选择不同运算方法的字符、定义记录运算符左边的数字的数、定义记录运算符右边的数字的数、定义记录运算结果的数、定义用于记录开平方根和进行正负数切换的数字的数。

基础定义完成后，进行初始化控件，通过定位函数findViewById()引用XML文件里面的Button，使得在写java文件时候的按钮时能与XML文件里的保持一致，使用时需进行强制转换，按钮则使用Button进行强制转换，文本框则使用EditText进行强制转换。

初始化控件完成后，进行初始化事件，对数字0-9、运算符（加、减、乘、除、等于、开平方根）、小数点、清零、切换正负的按钮控件通过setOnClickListener()方法设置点击事件监听器。

监听器设置完成后，此时可以对点击事件进行监听，但并没有对监听到点击事件后应发生什么进行设置，此时就需要进行对点击事件进行设置。点击事件发生后，需要对不同的点击行为做出不同的响应处理，通过switch函数进行分类管理。先获取文本框中内容并设置字符串进行记录，当发生点击数字的事件后，将点击的数字按钮对应的数字添加到字符串中，并通过setText()方法将其显示在EditText控件中；当发生点击清零按钮的事件是，将字符串设置为空，并通过setText()方法将其显示在EditText控件中；当发生点击加法按钮的事件时，先获取文本框内容（文本为数字）并转换为Double类型并记录，向字符串中加入加号，并记录此次运算方法符号为“+”，清空EditText控件文本内容，等待后续计算事件；当发生点击减法按钮的事件时，先获取文本框内容（文本为数字）并转换为Double类型并记录，向字符串中加入减号，并记录此次运算方法符号为“-”，清空EditText控件文本内容，等待后续计算事件；当发生点击乘法按钮的事件时，先获取文本框内容（文本为数字）并转换为Double类型并记录，向字符串中加入乘号，并记录此次运算方法符号为“*”，清空EditText控件文本内容，等待后续计算事件；当发生点击除法按钮的事件时，先获取文本框内容（文本为数字）并转换为Double类型并记录，向字符串中加入除号，并记录此次运算方法符号为“/”，清空EditText控件文本内容，等待后续计算事件；当发生点击小数点按钮的事件后向字符串中添加小数点，并过setText()方法将字符串内容显示在EditText控件中；当发生切换正负按钮的点击事件后，为区别之前功能的数字存储，单独设置一个新的数，获取当前文本框的内容并转换成Double类型并存储在这个新的数当中，对字符串进行判断，若字符串长度大于零，继续判断当前数字是否大于零，是则添加负号并输出到EditText控件中，否则直接输出到EditText控件中；当发生点击开平方根运算按钮的事件后，为区别之前功能的数字存储，单独设置一个新的数，获取当前文本框的内容并转换成Double类型并存储在这个新的数当中，如果当前数字的值小于零，则在EditText控件中提示报错内容，显示"负数不能被开平方！"，否则对数字通过Math.sqrt()方法进行开平方根运算，并将结果输出到EditText控件中。

在数字和运算符的选择过程中，第一次点击数字，会在文本框中显示当前点击的数字，获取文本框内容并把数字存储到字符串中，点击加减乘除运算符，会向字符串中加入相对应的运算符（“+”“-”“*”“/”），记录对应的运算方法并清空文本框，点击第二个数字，会在文本框中显示当前点击的数字，并获取文本框内容并把数字存储到字符串中，点击计算按钮（符号为“=”），其会根据之前对运算方法的记录选择不同的运算方法，同时进行数据校验，非法数据则报错。于是，当点击计算按钮事件发生后，获取文本框内容，并把当前文本框中的数字进行单独存储，根据不同的运算方法对第一个数字和第二个数字进行不同的运算操作，加法、减法、乘法在完成运算后需依次在文本框输出第一个数字、运算符、第二个数字、等于号、计算结果，除法运算需进行数据校验，当发现第二个数字为零时，进行报错提示“除数不能为0！"，不为零时则也在完成运算后需依次在文本框输出第一个数字、除号、第二个数字、等于号、计算结果。

以下为运行效果图：

![image](https://user-images.githubusercontent.com/73420535/150103467-b1ee32ea-8e10-481c-9d8a-990037f51e2f.png)
![image](https://user-images.githubusercontent.com/73420535/150103491-53f36414-cd73-468a-b8ed-35174136f243.png)

