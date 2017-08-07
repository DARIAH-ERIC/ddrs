---
layout: page
title: DDRS
description: Concept of the DDRS
---
[Back to DDRS index](index.md)

![alt text](https://github.com/DARIAH-ERIC/ddrs/blob/master/docs/contents/HaS_Logo_klein.png "Humanities at Scale")

## Concept of the service
The service connects researchers who search for a deposit service on the one hand and the repositories and data centres on the other hand which have a mandate to acquire content and it aims at establishing incentives for both sides to deposit and ingest research data in the humanities.

The service is technically a registry of deposit services for research data from the Humanities. It catalogues repositories and research data centres and delivers standardised metadata on them, allowing the researcher to decide which repository may be the most qualified one for his case. The collection of the data will initially be done manually but anticipate future automated procedures to harvest data from repositories. The registry takes into account the heterogeneity of data and the often compartmentalised research structures in the humanities. Obviously it also takes into account already established services such as re3data.org but functions – as a main distinction – on a discipline-specific level.

#### For whom is the DDRS useful?
The DDRS is geared towards researchers and research projects from the arts and humanities, especially from the digital humanities.

#### What is the main function of the DDRS?
It addresses the question of how and where to deposit research data, an issue gaining increasingly importance as reuse of research data becomes more common and more funders require the deployment of data taking into account the aspect of reproducibility of research. Through a guided concise inquiry of the user the system recommends the best suited data deposit locations for the individual case. The user can compare the results of his request and gets then pointed to these deposit locations.

#### Additional functions
Beyond this main objective the DDRS also aims at raising awareness for research data repositories and improve collaboration and interoperability between such services. An area with large potential in this regard will be the use of re3data.org database for identifying suitable repositories for the researcher.

#### User workflow

##### Identification of suitable repositories
The first tier aims at identifying suitable repositories for the user with requesting answers to no more than a handful of questions. The user receives a ranked list of repository recommendations. The ranking is based on an internal but simple mechanism. For instance a repository that is able to offer certain services or functionalities gets ranked higher than a simple repository only able to store file-based research data. These areas do not have to be answered by the user because the ranking can be undertaken quite simply on the service side and because most users probably care about areas as licensing, metadata schemas or long-term preservation but may not be able to verbalise them in information science terminology.

The repository registry and recommender function will initially be implemented on a simple technical level. With progress in coverage and usage, the service will become more sophisticated. The current workflow of the user through the two tiers - repository recommendation and data description/ contact with repository.

The service will guide researchers and research institutions to the most qualified services for their individual depositing concern. What kind of research data can be deposited in which repositories or data centres, what requirements do they have to meet, how does the ingest process work, who can be consulted, what are the costs and necessary service level agreements? These kind of questions will initially be answered only rudimentary as the researcher browses through a catalogue of research data repositories and data centres.

A good visualisation of such a faceted browsing could look like [re3data.org](http://www.re3data.org/) has implemented the browsing by subject. The underlying technical solution uses a database with repositories tagged with classifications of the covered content. The user browses through this metadata and gets very quickly results, leading him to the desired repositories.

A similar solution is at hand for HaS. Depending on the detail of the metadata on the repositories that is available various use cases become possible. With a more detailed description of the metadata a more branched inquiry of the researcher’s individual requirements becomes feasible allowing more individually tailored results and thereby improving the user experience. To achieve such a maturity and usefulness in service quality requires one the hand a stable technical solution, on the other hand - and possibly more important - a rich and reliable database.

![alt text](https://github.com/DARIAH-ERIC/ddrs/blob/master/docs/contents/concept.png "Concept")

##### Individual case description to initiate the communication process between researcher and repository
In the second tier the user may - if he wishes so - describe his or her specific case, i.e. the research data that shall be deposited. The research data concerned is described by the user along a few standardised categories, like format, data volume, licences and so on. Aim of this description is to allow the repository an overview of the specific ingest case and to prepare for the communication with the researcher. This information, along with personal contact information, flows into a form that can be forwarded to the prefered repository at the instigation of the user. The second tier is optional, in other words, the user should have useful information about a suitable repository for their Data Management Plan, after the first tier.