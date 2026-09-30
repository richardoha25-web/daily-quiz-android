# RichInsights — Native Android V2 Roadmap

> **Master V2 document.** This repository is a clean native Android rebuild. V1 is a prototype/reference only; V1 code and behavior are not assumed to be production-ready.

## 1. Product identity

- **Company/studio:** Ricven Studios Limited
- **Product/platform:** RichInsights
- **Tagline:** **Grow. Excel.**
- **Repository:** `ricvenlimited/richinsights-android`
- **Android application/package identity:** `com.ricven.richinsights`

RichInsights is an educational platform, not only a quiz app. The initial platform centers on **Home, Learn, Quiz, Bible, and News**, with Profile & Settings as secondary/global navigation.

The native V2 architecture must make future learning tools, content libraries, study features, progress, accounts, and commercial capabilities possible without rebuilding the application shell.

## 2. V2 reset principle

V2 is a **new architecture**, not a port of React/Vite/Capacitor.

V1 may be inspected for:
- product lessons;
- useful UX ideas;
- known failures;
- requirements we do not want to repeat.

V1 must **not** be treated as a source of production-ready code, question data, API architecture, AdMob implementation, or application structure.

Do not mechanically copy V1 systems into V2.

## 3. Primary navigation

### Compact phones
**Home | Learn | Quiz | Bible | News**

### Secondary/global
**Profile & Settings** is accessed from the top app bar/profile action rather than taking a sixth primary slot.

### Adaptive behavior
On larger windows, primary navigation should adapt to a navigation rail or another appropriate adaptive pattern rather than forcing a phone-sized bottom bar. Android currently recommends 3–5 primary destinations for compact navigation and adapting navigation for larger screens.

Top-level destinations should retain their navigation state/back stack where appropriate. Navigation 3 is a strong candidate for V2 because it provides explicit back-stack control and adaptive navigation patterns; the exact library/version will be locked during implementation against the current project setup.

## 4. Core V2 architecture

Target stack:
- Kotlin
- Jetpack Compose
- modern Android architecture
- ViewModel
- Coroutines / Flow / StateFlow
- repository/data-source separation
- type-safe navigation approach
- Room where local structured persistence is required
- DataStore for preferences/settings
- native networking
- Hilt if dependency-injection complexity justifies it
- WorkManager only for genuine background work
- native Google Mobile Ads SDK
- backend/provider architecture selected for V2 requirements rather than inherited automatically from V1

Conceptual client flow:

```
Compose UI
   ↓
UI State / ViewModel
   ↓
Repository
   ↓
Remote + Local Data Sources
```

Provider-specific generation logic belongs outside the Android presentation layer.

## 5. Backend and infrastructure architecture

The current V2 backend direction is **Firebase-first**:
- Firebase Cloud Functions using Python for server-side/backend logic;
- Cloud Firestore as the initial database;
- Firebase Authentication;
- Firebase Cloud Storage;
- Firebase Cloud Messaging;
- Firebase Analytics;
- Firebase Crashlytics;
- Firebase Remote Config;
- Firebase App Check;
- protected backend secrets/Secret Manager;
- Google Play Billing for Android commercial flows when implemented.

SQL Connect/PostgreSQL is deliberately deferred. Cloudflare is not required for V2 initially and the V1 Cloudflare Worker remains a prototype/reference rather than the V2 foundation.

RichInsights is **online-first**, not broadly offline-first. Selected Home/Profile data may be cached, explicitly downloaded Learn content may work offline, and properly licensed Bible reading is intended to work offline. Quiz, News, Current Affairs, fresh Learn browsing/downloads, synchronization, and server-backed Bible features require internet.

The detailed backend, security, content-pipeline, connectivity, cost-control, Firebase, Cloudflare, and infrastructure decisions are maintained in **`richinsights-backend-architecture.md`**. That document is authoritative for detailed backend architecture.

## 5. Content and question architecture

The question system is being rebuilt from the ground up.

The platform must separate:

1. **Content sources** — APIs, public/structured data, licensed data, manual authoring, curated packs, trusted sources.
2. **Ingestion/normalization** — convert source material into a consistent internal representation.
3. **Verification and validation** — factual, structural, answer, distractor, language, and quality checks.
4. **Question generation/authoring** — create legitimate question variants from verified material.
5. **Question bank** — store approved questions and their provenance.
6. **Selection engine** — choose appropriate fresh questions for a user/session.
7. **History** — record what the user has already seen.

Question identity must support at least:
- `factId`
- `familyId`
- `variantId`
- `questionId`
- category/topic
- difficulty
- provenance/source
- validation/lifecycle status

A wording change does not automatically make a genuinely new educational question. Family-level repetition must be controlled where appropriate.

### Scale requirement

V2 must be capable of growing to a very large question universe, potentially millions of legitimate variants over the life of the platform. Scale must come from verified content and meaningful variants, not low-quality duplication.

The system must continuously replenish content. A small exhausted cache must not be the normal failure mode.

## 6. Provider independence

No single provider is the architecture.

Providers may be added, removed, replaced, or combined without rewriting the quiz engine. A provider outage, pricing change, quota, or quality problem should be isolated from the learner-facing quiz experience as much as reasonably possible.

The final provider mix is deliberately **not locked yet**.

## 7. Initial learning/content areas

The initial product direction includes:
- General Knowledge
- Science
- Africa & Nigeria
- Current Affairs
- Bible

**News** is a separate top-level product area and should not be treated as merely another Current Affairs API.

Bible is a dedicated platform section, not simply a quiz category.

## 8. Bible direction

Planned future Bible capabilities:
- offline reading using appropriately licensed text;
- book/chapter navigation;
- search;
- online Bible quizzes;
- future study tools;
- user-triggered read-aloud with play/pause/resume/stop controls.

WEB remains the leading translation direction from earlier planning, but licensing/distribution requirements must be verified before implementation or distribution.

Read-aloud must never start automatically when a chapter opens.

## 9. Network and local data behavior

RichInsights is **online-first / internet-required for most platform functionality**, not broadly offline-first.

Selected local/offline support is intentional:
- **Home:** only selected basic/cached portions may remain available offline; fresh/live content and recommendations require internet.
- **Profile:** selected cached profile data such as profile image, streaks, progress, and history may remain available offline; synchronization requires internet.
- **Learn:** only courses/content the user explicitly downloaded may be available offline; fresh browsing and downloads require internet.
- **Bible:** properly licensed Bible reading is intended to work offline, including book/chapter/verse navigation and reading.

The following require internet:
- Quiz;
- News;
- Current Affairs;
- fresh Learn browsing/downloads;
- fresh Home content/recommendations;
- Bible quizzes;
- server-backed Bible study features;
- synchronization/live content.

The app must provide deliberate states for:
- online;
- connecting;
- offline;
- connection lost;
- loading/requesting;
- empty result;
- temporary failure;
- retry;
- feature unavailable because internet is required.

Local persistence may use Room/DataStore and other appropriate local storage. Cached history must not silently become an offline quiz source when the product requires online quiz availability.

See `richinsights-backend-architecture.md` for the authoritative connectivity and local-data boundaries.

## 10. Monetization and commercial architecture

V2 will use a fresh commercial architecture rather than copying V1.

Planned capabilities:
- AdMob advertising;
- optional rewarded ads;
- Premium subscription;
- Remove Ads;
- premium content/features;
- future content packs;
- Google Play Billing;
- centralized entitlement state.

Commercial enforcement is **not** an initial prerequisite for the native shell.

The client must not let individual question providers, screens, or question records independently decide Premium access.

## 11. Development and quality rules

Use:

**BUILD → INSTALL → TEST → FIX → DOCUMENT → CHECKPOINT → NEXT STAGE**

Requirements:
- keep V1 untouched while V2 is built;
- keep V2 buildable at every meaningful checkpoint;
- test on real Android hardware;
- add automated tests where they provide meaningful protection;
- do not optimize for feature count at the expense of reliability;
- document only decisions that remain useful to implementation.

## 12. Implementation stages

### Stage 0 — Requirements and architecture
**Status: documented / checkpointed**

Product identity, V2 reset principle, navigation, architecture boundaries, content/question requirements, and major quality requirements are documented.

### Stage 1 — Native application foundation
**Status: in progress**

Stage 1 is being executed strictly in order. We do not jump ahead to backend/content features while a foundation step is still being established.

#### Stage 1 execution order

1. **Create the native Android project**
   - Kotlin
   - Jetpack Compose
   - application/package identity: `com.ricven.richinsights`
   - native Android project structure

2. **Establish the Gradle/project foundation**
   - Gradle configuration
   - SDK configuration
   - dependency management
   - Compose/build configuration

3. **Establish the initial RichInsights design system**
   - theme foundation
   - color tokens
   - typography
   - spacing/shapes conventions
   - reusable UI foundation
   - light-theme foundation with structure ready for dark theme later
   - existing placeholder connected to `RichInsightsTheme`

4. **Establish the navigation shell**
   - initial primary navigation architecture
   - Home / Learn / Quiz / Bible / News shell
   - Profile & Settings remains secondary/global
   - navigation structure only; no premature full product screens

5. **Firebase foundation**
   - create/connect the RichInsights Firebase project
   - register `com.ricven.richinsights`
   - add Firebase configuration
   - connect Firebase to Android
   - verify the connection with a minimal test
   - do **not** yet populate Firestore collections, quiz questions, authentication flows, Cloud Functions, or production content logic

   **Important sequencing note:** Firebase was intentionally paused while the product identity layer was being properly defined. The Firebase step remains next after the brand/launch work is sufficiently settled.

6. **Build and install the first V2 APK**
   - build the real project
   - install on a physical Android device
   - verify launch and foundation behavior

7. **GitHub checkpoint**
   - commit the working foundation
   - push to `ricvenlimited/richinsights-android`

8. **Stage 1 checkpoint**
   - verify the foundation
   - resolve remaining issues
   - freeze the Stage 1 foundation
   - proceed to Stage 2

#### Brand & Launch Identity checkpoint inserted before Firebase implementation

The product identity work was identified as important before moving into Firebase integration. It does **not** replace or restructure the navigation shell.

The identity work covers:
- RichInsights brand mark/symbol;
- launcher/app icon direction;
- adaptive icon requirements;
- `Grow. Excel.` tagline usage;
- Android launch/splash experience;
- Figma-based visual exploration and editable design assets.

Current state:
- the UI/UX documentation has been updated with the brand/launch plan;
- a dedicated Figma file, **RichInsights — Brand & Icon Concepts**, has been created;
- the Figma board contains six deliberately different editable concept directions for exploration;
- no icon concept has been approved as final;
- no production launcher assets have been integrated into Android yet;
- the launch animation/storyboard is still conceptual and will be finalized after the brand mark is selected.

This identity checkpoint is a controlled addition to Stage 1. It does not invalidate Steps 1–4 or require the navigation shell to be rebuilt.

### Stage 2 — Platform UI foundation
- RichInsights visual system
- reusable components
- adaptive layouts
- loading/error/empty states
- accessibility foundations
- Home/Learn/Quiz/Bible/News shell

### Stage 3 — Content/domain contracts
- category/topic models
- question/fact/family/variant/ID models
- provenance and validation metadata
- quiz-session/result models
- stable API contracts

### Stage 4 — Quiz engine
- session state
- question presentation
- answer handling
- timer
- scoring
- progression
- completion/results
- failure/retry states

### Stage 5 — Backend/content integration
- connect to the selected V2 backend/content services
- network handling
- content validation boundaries
- provider-independent contracts

### Stage 6 — History and freshness
- local history persistence
- exact-question and family-level repetition rules
- selection/freshness integration
- replenishment behavior

### Stage 7 — Initial content rollout
Bring categories online incrementally:
- General Knowledge
- Science
- Africa & Nigeria
- Current Affairs
- Bible quiz capability where ready

### Stage 8 — Bible platform experience
- offline reader
- licensed content
- search/navigation
- read-aloud controls
- Bible-specific study foundations

### Stage 9 — News and broader platform features
- News experience
- progress/account foundations
- future learning resources
- additional educational modules

### Stage 10 — Commercial and release hardening
- native AdMob
- Google Play Billing when required
- entitlement enforcement
- performance/accessibility/security testing
- release preparation

Stages can be subdivided as implementation progresses. A stage is complete only when its scope is tested and documented.

## 13. Definition of success

V2 succeeds when RichInsights has a maintainable native Android foundation with:
- clear platform navigation;
- strong quiz/session behavior;
- scalable and provider-independent content architecture;
- validated, traceable questions;
- robust repetition prevention and freshness;
- continuous content replenishment;
- deliberate Bible support;
- reliable network behavior;
- adaptive native UI;
- clean separation of client, content, infrastructure, and commercial concerns;
- room for future educational products.

**V2 is an educational platform foundation — not V1 rebuilt with a new UI.**

### Current Stage 1 checkpoint

Stage 1 has completed the native project, initial design-system, and navigation-shell foundation work. The current active work is the documented Brand & Launch Identity checkpoint in Figma. Firebase remains deliberately unimplemented until that identity work is sufficiently settled. No backend, quiz logic, monetization, or production content has been pulled forward.