# 教諭管理システム

## 使い方
1.このプロジェクトをダウンロード　
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/8cdbc38d-f099-41fb-8702-cbd8451cabf0)

2．パソコンで解凍する

3．Mysqlにtliasを作成する
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/a5bbf9fb-f4fb-4fa0-852d-4b5e595c3e90)

4.nginx-1.22.0-tliasファイルにあるTestDate.sqlを使って、データーを導入してから使ってください
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/fc37e431-1bae-4cd9-a52a-9ef8f9cabde7)

5．nginx.exe起動する(pathに漢字，仮名ないところに開いてください)
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/f7fc4484-4026-4832-baff-22d8792f28e1)

6．MyPMS.exeを起動する(文字化けの可能性があり、解決法はIDEAにてPersonnelManagementSystemApplication.javaで起動すること)
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/754676cc-5adb-4e3b-9b45-99814eb39e3b)

7."http://localhost:90"でシステムページを開く

※Vueのソースコードはvue-adminにあります。


## 詳細
JAVAのSpring Boot とVue合わせて、作った教諭管理システムです。

Vueでフロントエンド側のものを作り、処理性能・高い並行性・メモリ使用量の小さいNGINX使って、Vueでできたものを載せました。

このポートフォリオは主にサーバー、APIの設計などを中心に作成しました。

また、インターセプターとJWTなど用いて、Token作成と検証、フロントエンドとブックエンド両方をうまく連携取れる練習として作ったものです。


## イメージ図　
サーバー
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/75774abb-18fa-4fa0-8f83-12fb00f7ea1b)

サイトページ
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/b95427b2-4879-4de8-bac1-d45ed85bcf02)
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/1d1c9651-df2a-43e5-8dc4-13eab8874001)
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/15686d27-66dc-470d-8511-3e17a87f8245)
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/763df75b-e192-4f5c-a1de-241c9d5bf105)
![image](https://github.com/g8uy65f43/personnel_management_system-/assets/105122594/f15677ea-c096-4be7-8958-376e8d4915ba)
