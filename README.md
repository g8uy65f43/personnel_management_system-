# 教諭管理システム

## 使い方
1.このプロジェクトをダウンロード　

2．nginx-1.22.0-tlias.rarを解凍  

3．Mysqlにtliasを作成して、nginx-1.22.0-tliasファイルにあるTestDate.sqlを使って、データーを導入してから使ってください

4．nginx.exe起動する

5．PersonnelManagementSystemApplicationを起動する

6.http://localhost:90　でシステムページを開く

## 詳細
JAVAのSpring Boot とVue合わせて、作った教諭管理システムです。
Vueでフロントエンド側のものを作り、処理性能・高い並行性・メモリ使用量の小さいNGINX使って、Vueでできたものを載せました。
このポートフォリオは主にサーバー、APIの設計などを中心に作成しました。
また、インターセプターとJWTなど用いて、Token作成と検証、フロントエンドとブックエンド両方をうまく連携取れる練習として作ったものです。


## イメージ図　
サーバー

サイトページ
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/b95427b2-4879-4de8-bac1-d45ed85bcf02)
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/1d1c9651-df2a-43e5-8dc4-13eab8874001)
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/15686d27-66dc-470d-8511-3e17a87f8245)
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/763df75b-e192-4f5c-a1de-241c9d5bf105)
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/f15677ea-c096-4be7-8958-376e8d4915ba)