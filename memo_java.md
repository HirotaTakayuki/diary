### spring boot 特徴

DI（依存性の注入）
※Dependency Injection
Javaで作成するアプリケーションは基本複数のクラスで成り立っています。
↓のようなサンプルにある通り他のクラスを「new」してインスタンス化し使用します。
CalcServiceクラスが存在しないと動かないクラスとなります。
それをDemoクラスはCalcServiceに依存しているというような表現をします。