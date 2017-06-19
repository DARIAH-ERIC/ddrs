---
layout: page
title: DDRS
description: Concept of the DDRS
---
[Back to DDRS indext](index.md)

# Data Deposit Recommendation Service for Research Data Repositories in the Humanities.
## Concept of the Service
The concept of the DDRS is based on the following three assumptions taking the development concept within the Humanities at Scale project and a sustainability perspective for the service into account:
* focus on one or at least only a few functionalities.
* to base the service from the very beginning on using third party services.
* to keep it interoperable especially with regard to research data repositories.

#### For whom is the DDRS useful?
The DDRS is geared towards researchers and research projects from the arts and humanities, especially from the digital humanities.

#### What is the main function of the DDRS?
It addresses the question of how and where to deposit research data, an issue gaining increasingly importance as reuse of research data becomes more common and more funders require the deployment of data taking into account the aspect of reproducibility of research. The user experience of the service should be kept as simple as possible. Through a guided concise inquiry of the user the system recommends the best suited data deposit locations for the individual case. The user can compare the results of his request and gets then pointed to these deposit locations.

#### Additional functions
Beyond this main objective the DDRS also aims at raising awareness for research data repositories and improve collaboration and interoperability between such services. An area with large potential in this regard will be the use of re3data.org database for identifying suitable repositories for the researcher.

#### User workflow
The first tier aims at identifying suitable repositories for the user with requesting answers to no more than a handful of questions. The user receives a ranked list of repository recommendations. The ranking is based on an internal but simple mechanism. For instance a repository that is able to offer certain services or functionalities gets ranked higher than a simple repository only able to store file-based research data. These areas do not have to be answered by the user because the ranking can be undertaken quite simply on the service side and because most users probably care about areas as licensing, metadata schemas or long-term preservation but may not be able to verbalise them in information science terminology.

![alt text](https://github.com/DARIAH-ERIC/ddrs/blob/master/docs/contents/concept.png "Concept")

In the second tier the user may - if he wishes so - describe his or her specific case, i.e. the research data that shall be deposited. The research data concerned is described by the user along a few standardised categories, like format, data volume, licences and so on. Aim of this description is to allow the repository an overview of the specific ingest case and to prepare for the communication with the researcher. This information, along with personal contact information, flows into a form that can be forwarded to the prefered repository at the instigation of the user. The second tier is optional, in other words, the user should have useful information about a suitable repository for their Data Management Plan, after the first tier.