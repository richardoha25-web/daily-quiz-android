# Daily Quiz Android — Native Android Roadmap

## 1. Project Identity and Long-Term Direction

Repository: `richardoha25-web/daily-quiz-android`

This repository is the foundation for the **native Android educational platform**. It is not a mechanical rewrite of V1 and should not be treated as only a quiz application.

V1 remains the existing React/Vite/Capacitor product. Native Android is a new client architecture designed for the long-term platform direction.

The platform begins with quizzes and Bible capabilities, but its architecture must remain extensible for additional educational sections, learning tools, content libraries, and future commercial capabilities.

### Core principle

> Build a scalable educational platform in which quizzes are one major learning experience, not the definition of the entire product.

The native client should therefore use modular navigation and feature boundaries so future sections can be added without restructuring the entire application.

---

## 2. V1 Lessons That Must Carry Into V2

V1 has established working product behavior and exposed architectural lessons that must be preserved deliberately rather than rediscovered during native implementation.

### 2.1 Quiz/content lessons

V2 must preserve and improve:

- unique question IDs and persistent question history;
- protection against exact question repetition;
- protection against inappropriate repetition of related question families where required;
- distinction between a verified fact, a question family, a question variant, and a user-visible question;
- question provenance through source/fact identifiers;
- difficulty metadata;
- validation before questions reach the learner;
- fresh-question selection;
- continuous replenishment when the available fresh pool becomes low;
- separation of content generation from the Android UI and quiz presentation;
- category-specific source strategies without coupling the quiz engine to one provider.

### 2.2 Text and presentation lessons

The native app should render learner-facing text as native Android/Compose UI rather than as web/HTML-style selectable text.

Default learner-facing quiz and interface text should not be casually selectable/copyable. Do not wrap ordinary question, option, category, button, explanation, or result text in a selection container merely to display it. Text appearance should be deliberately designed through native typography, spacing, hierarchy, and accessibility-aware Compose components.

This is a practical anti-copy/selectability requirement, not a claim that screenshots, OCR, accessibility tooling, debugging, or other extraction methods can be absolutely prevented.

---

## 3. Multi-Source Educational Content Architecture

V2 must not make the question engine dependent on one API, provider, or data source.

The content system should support multiple independent sources, including where appropriate:

- external APIs;
- structured public datasets;
- trusted knowledge sources;
- news/current-affairs providers;
- Scripture/Bible data sources subject to licensing;
- internally verified facts;
- manually authored questions;
- curated question packs;
- future specialized educational providers.

### Provider independence

The quiz engine should request validated content according to category, difficulty, freshness, and other requirements. It should not need to know which provider supplied the underlying fact or question.

Conceptually:

```text
Multiple Sources
      ↓
Fact / Content Ingestion
      ↓
Verification + Provenance
      ↓
Question Generation / Authoring
      ↓
Validation
      ↓
Question Bank
      ↓
ID + Family + Variant Metadata
      ↓
Freshness / History Selection
      ↓
Quiz Engine
```

Providers must be replaceable or additive. If a provider becomes unavailable, changes pricing, imposes limits, or becomes unsuitable, the platform should be able to use another source or internal content without redesigning the quiz engine.

---

## 4. Large-Scale Question Generation Vision

The V2 content architecture should be capable of supporting a very large question universe, potentially reaching **millions of legitimate generated question variants** over the life of the platform.

This does not mean blindly storing millions of low-quality questions. Scale must come from a controlled relationship between:

- verified facts;
- question families;
- generation templates/rules;
- legitimate variants;
- difficulty levels;
- category scope;
- freshness requirements;
- curated/manual content;
- validation and deduplication.

One verified fact may support multiple legitimate question forms, but each generated question must still have identity, provenance, validation state, and family/variant relationships.

The architecture should therefore support:

```text
Verified Fact
    ↓
Question Family
    ├── Variant A
    ├── Variant B
    ├── Variant C
    └── ...
```

The system must avoid treating superficial wording changes as genuinely new educational questions when they test the same thing.

---

## 5. Question Identity, Validation, and Repetition Architecture

Question identity is a first-class platform concern.

At minimum, the content model should be able to distinguish:

- `factId` — underlying verified knowledge;
- `familyId` — conceptual question family;
- `variantId` — legitimate generated variant;
- `questionId` — unique user-visible question identity;
- source/provenance metadata;
- difficulty;
- lifecycle/validation status.

The question lifecycle should conceptually be:

```text
Verified Fact
      ↓
Question Concept
      ↓
Question Family
      ↓
Generated / Authored Variant
      ↓
Structural + Factual Validation
      ↓
Approved Question
      ↓
Question Bank
      ↓
Fresh-Question Selector
      ↓
Quiz Session
      ↓
User History
```

The freshness system must distinguish exact repetition from family-level repetition. A player should not be shown the same question again simply because its wording was slightly changed, when the product rules consider that the same learning target.

Question generation, validation, selection, and history must remain separate concerns.

---

## 6. Continuous Content Replenishment

The platform must not depend on a small fixed cache that can be exhausted.

When a category's fresh supply becomes low, the system should be able to:

1. request or ingest additional source material;
2. generate additional questions;
3. validate and deduplicate them;
4. add approved questions to the available pool;
5. select fresh questions for the learner.

If one provider cannot supply enough material, another compatible source or internal content should be available where the category permits it.

The learner should not receive a generic "not enough fresh questions" failure merely because one small cache has been consumed.

---

## 7. Educational Platform Navigation and Feature Direction

The native application should be designed around platform-level navigation rather than a single quiz screen.

The roadmap should support a small primary navigation set (approximately 4–5 destinations initially, subject to UI/UX validation) while leaving room for future sections.

Initial conceptual areas may include:

- **Home** — educational starting point, recommendations, progress, and entry points;
- **Learn / Quiz** — the existing quiz experiences and future learning activities;
- **Bible** — Bible reading/library and future Bible study capabilities;
- **Explore / Library** — future educational resources and content;
- **Profile / Progress** — future learner progress, settings, and account capabilities.

These are architectural concepts, not a final locked navigation design. The exact destinations, labels, and order should be established during UI/UX implementation.

Adding a future educational section should be an extension of the platform rather than a rewrite of the application shell.

---

## 8. Bible as a Major Platform Section

Bible should not be modeled merely as another quiz category.

The planned Bible capability includes a future offline Bible library using appropriately licensed text, with WEB as the leading version direction from V1 planning, plus online Bible quizzes and future study capabilities.

Potential future Bible capabilities include:

- offline reading;
- book/chapter navigation;
- search;
- online quizzes;
- study tools;
- user-triggered read-aloud with explicit play/pause controls;
- future licensed Bible resources.

Licensing requirements must be verified before distributing any Bible translation or copyrighted resource.

---

## 9. Native Android Technical Foundation

Primary stack:

- Kotlin;
- Jetpack Compose;
- ViewModel;
- Coroutines;
- Flow / StateFlow;
- lifecycle-aware state collection;
- Repository/data-source separation;
- Navigation for Compose;
- Room where structured local persistence is required;
- DataStore for preferences/settings;
- native Android networking;
- Hilt if dependency injection complexity justifies it;
- WorkManager only where background work is genuinely required;
- native Google Mobile Ads SDK for advertising;
- existing Cloudflare Worker initially where the API contract fits.

Target architecture:

```text
Compose UI
    ↓
Screen / UI State
    ↓
ViewModel
    ↓
Repository
    ↓
Remote + Local Data Sources
    ↓
Cloudflare Worker / External Providers / Room / DataStore
```

The Android client should not contain provider-specific question-generation logic that belongs in the content/backend layer.

---

## 10. Network and Data Behavior

The platform is internet-dependent for online quiz/content experiences, while selected local capabilities may work offline by deliberate design.

Network state handling should explicitly support states such as:

- ONLINE;
- CONNECTING;
- OFFLINE;
- CONNECTION_LOST;
- REQUESTING;
- ERROR.

Local question history can support anti-repetition decisions, but cached history must not silently become an offline quiz source unless that behavior is explicitly designed and documented.

---

## 11. UI/UX Direction

The native Android interface should follow the established "Clean Competitive" direction while evolving it for a broader educational platform.

Core visual principles:

- clean white foundation;
- strong blue as a primary identity color;
- restrained complementary accent;
- clear hierarchy;
- polished native typography;
- purposeful motion;
- accessible controls;
- responsive/adaptive layouts;
- professional and energetic without being childish;
- avoid excessive gradients and generic unmodified Material styling.

Material 3 may provide the foundation, but the platform should have a distinct visual identity.

The app must support phones and be designed with tablets, foldables, landscape, split-screen, and other adaptive window sizes in mind.

---

## 12. Commercial and Future Platform Architecture

The architecture should leave room for future:

- premium categories/content;
- locked educational packs;
- subscriptions;
- ad-free entitlements;
- Google Play Billing;
- account-based progress;
- cloud synchronization;
- personalization;
- additional educational products.

These capabilities should not be implemented prematurely. The architecture should avoid making them difficult to introduce later.

Firebase is not an initial requirement. It may be introduced later only for a concrete need such as authentication, analytics, crash reporting, remote configuration, or another justified service.

---

## 13. V1 Backend and Infrastructure Continuity

The native Android project should initially reuse the existing Cloudflare Worker where its contracts are suitable.

GitHub remains the source-control and development center. Cloudflare remains the initial backend/runtime platform. Neither should be treated as the question/content provider itself.

The platform architecture should remain provider-independent so that future infrastructure changes do not require rewriting the Android client or quiz engine.

---

## 14. Development Rules

Development remains incremental and test-driven:

**BUILD → INSTALL → TEST → FIX → DOCUMENT → CHECKPOINT → NEXT STAGE**

Do not attempt to build the entire platform at once.

Every major stage must leave the repository in a buildable/testable state before the next stage begins.

V1 should remain stable and preserved while V2 is developed separately.

Do not mechanically port V1 React/Vite/Capacitor code into the native project.

---

## 15. Native Android Implementation Stages

### Stage 0 — Planning and requirements
Status: **Completed / expanded**

Lock the platform vision, V1 lessons, technical stack, content architecture, question architecture, navigation direction, and major non-functional requirements.

### Stage 1 — Native Android shell

Create the Kotlin/Compose application shell, package identity, Gradle configuration, basic navigation, theme foundation, and build/install pipeline.

### Stage 2 — UI foundation

Implement typography, colors, spacing, reusable components, adaptive layout rules, loading/error states, accessibility foundations, and the native text behavior.

### Stage 3 — Content/question domain model

Implement the client-side contracts and models required to represent categories, question identity, question families/variants, difficulty, provenance, validation state, quiz sessions, and results.

Generation itself should remain in the appropriate content/backend layer.

### Stage 4 — Quiz engine

Implement quiz session state, question presentation, answer handling, scoring, progression, timers, completion, results, and appropriate error/empty states.

### Stage 5 — Network and backend integration

Connect the native client to the existing Cloudflare Worker using stable API contracts, with explicit network-state handling.

### Stage 6 — History and freshness

Implement local persistence for question history and related anti-repetition state. Integrate fresh-question selection according to the backend/content contract.

### Stage 7 — Category expansion

Bring the planned categories online incrementally, including General Knowledge, Africa & Nigeria, Current Affairs, Science, and Bible quiz capabilities where appropriate.

### Stage 8 — Bible platform section

Build the dedicated Bible navigation and reading/library foundation after licensing and content requirements are confirmed.

### Stage 9 — Platform expansion

Add future educational sections, Explore/Library capabilities, progress/account features, and other platform modules only when their requirements are defined.

### Stage 10 — Monetization and release hardening

Introduce native advertising, future entitlements/billing where required, release validation, performance testing, accessibility testing, security review, and production release preparation.

Stages may be subdivided further as implementation begins. No stage should be considered complete until it has been built, installed/tested where applicable, documented, and checkpointed.

---

## 16. Definition of V2 Success

V2 is successful when the native Android application is not merely a faster or prettier version of V1, but a maintainable educational platform with:

- native Android architecture;
- modular platform navigation;
- strong quiz functionality;
- scalable multi-source content generation;
- validated and traceable questions;
- robust repetition avoidance and freshness management;
- continuous content replenishment;
- a path toward a very large question universe;
- a dedicated Bible experience;
- reliable network handling;
- deliberate native UI/UX;
- room for additional educational sections;
- room for future accounts, personalization, and commercial features;
- stable separation between client, content system, and infrastructure.

The long-term objective is **an expandable educational platform**, not simply a quiz application.
