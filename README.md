<p align="center">
<img width="256" height="256" src="images/oewntk.png" alt="OEWNTK">
</p>
<p align="center">
<img width="150"src="images/mavencentral.png" alt="MavenCentral">
</p>

# Open English Wordnet WNDB-to-SQL grinder

This library reads a model from WNDB files and writes it to SQL format.

Project [grind_wndb2sql](https://github.com/x-englishwordnet/grind_wndb2sql)

See also [model](https://github.com/x-englishwordnet/model/blob/master/README.md).

See also [fromwndb](https://github.com/x-englishwordnet/fromwndb/blob/master/README.md).

See also [tosql](https://github.com/x-englishwordnet/tosql/blob/master/README.md).

See also [x-englishwordnet](https://github.com/x-englishwordnet) and [globalwordnet/english-wordnet](https://github.com/globalwordnet/english-wordnet).

## Dataflow

![Dataflow](images/dataflow_wndb2sql.png  "Dataflow")

This library reads from WNDB files and other WNDB files that contain extra data.

This output conforms to the **SQL** standards.

## Command line

`grind.sh [WNDB] [WNDB2] [SQL]`

grinds the SQL database

*where*

[WNDB]    directory where OEWN distribution WNDB files are

[WNDB2]  directory where extra WNDB extra files are

[SQL]      directory where SQL files are output

## Maven Central

		<groupId>io.github.x-englishwordnet</groupId>
		<artifactId>wndb2sql</artifactId>
		<version>1.0.0-SNAPSHOT</version>

## Dependencies

![Dependencies](images/grind-wndb2sql.png  "Dataflow")
